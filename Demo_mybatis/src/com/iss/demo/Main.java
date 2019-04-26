package com.iss.demo;

import com.iss.Mapper.UserMapper;
import com.iss.po.Users;
import com.iss.util.DBUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
//            //定义配置文件的名字
//            String resource="AppConfig.xml";
//
//            //读取配置文件
//            InputStream inputStream=Resources.getResourceAsStream(resource);
//
//            //创建一个SqlSessionFactory,可以理解为创建了一个Connection对象
//            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//
//            //创建一个SqlSession,可以理解为Statement
//            SqlSession sqlSession=sqlSessionFactory.openSession();
            //查询单个用户
//            Users user=sqlSession.selectOne("demo.findUserByName","rose");
//
//            System.out.println(user);
            //查询全部用户
//            List list=sqlSession.selectList("demo.findAllUser");
//            System.out.println(list);
//            SqlSession sqlSession=DBUtil.getSession();
            //添加用户
//            Users u=new Users();
//            u.setUname("zlq");
//            u.setUpwd("2333");
//            int x=sqlSession.insert("demo.addUser",u);

            //更新用户
//            Users u=new Users();
//            u.setUname("lll");
//            u.setUpwd("000000");
//
//            int x=sqlSession.update("demo.updateUser",u);

            //删除用户
//            int x=sqlSession.delete("demo.delUser","zlq");
//
//            sqlSession.commit();
//            sqlSession.close();
//
//            System.out.println(x);

            //新方式 利用mapper与mapper接口;
            SqlSession sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            List<Users> list = userMapper.findAllUser();
            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
