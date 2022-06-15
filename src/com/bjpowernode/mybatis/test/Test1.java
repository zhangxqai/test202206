package com.bjpowernode.mybatis.test;

import com.bjpowernode.mybatis.dao.StudentDao;
import com.bjpowernode.mybatis.domain.Student;
import com.bjpowernode.mybatis.service.Impl.StudentServiceImpl;
import com.bjpowernode.mybatis.service.StudentService;
import com.bjpowernode.mybatis.util.ServiceFactory;
import com.bjpowernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static void main(String[] args)  {

        StudentDao studentDao = SqlSessionUtil.getSession().getMapper(StudentDao.class);
        //根据id查询
        /*Student s = studentDao.select1("A1");
        System.out.println(s);*/

        //根据id查询返回多条数据，就是打包一个集合
        /*List<Student> s = studentDao.select2("A5");
        s.forEach(student -> System.out.println(student));
*/
        /*//根据name进行模糊查询
        List<Student> a = studentDao.select3("阿");
        a.forEach(student -> System.out.println(student));*/


        /*
        传参是map类型的，返回是实体类的类型的
        Map map = new HashMap();
        int being = 21;
        int eng = 25;
        map.put("being",being);
        map.put("eng",eng);
        List<Student> a = studentDao.select4(map);
        a.forEach(student -> System.out.println(student));*/


        /*
        统计记录条数的
        int count = studentDao.select5();
        System.out.println(count);
*/
      /*  //通过age查询，并返回一个map集合
        Map map = studentDao.select6(26);
        System.out.println(map);

        System.out.println(map.get("name"));*/

        List<Map> mapList = studentDao.select7();
        mapList.forEach(map -> System.out.println(map));


        for (Map map: mapList) {
            map.keySet();
            String i = (String) map.get("id");
            String name = (String) map.get("name");
            int a = (int) map.get("age");
            System.out.println("id是：" + i + ", name是：" + name + ", age 是：" + a);
        }
    }
}
