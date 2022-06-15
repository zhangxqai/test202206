package com.bjpowernode.mybatis.util;

import com.bjpowernode.mybatis.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    private SqlSessionUtil(){}

    private static SqlSessionFactory factory;
    static {

        InputStream in = null;

        try {
            //读取核心配置文件
            in = Resources.getResourceAsStream("mybatis-config.xml");

        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建代理工厂
        factory = new SqlSessionFactoryBuilder().build(in);

    }

    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();

    //获取SqlSession对象
    public static SqlSession getSession(){

        SqlSession session = t.get();

        if (session == null) {
            session = factory.openSession();

            t.set(session);
        }

        return session;
    }

    //关闭SqlSession对象
    public static void CloseSqlSession(SqlSession session){
        if (session != null) {

            session.close();

            t.remove();
        }
    }
}
