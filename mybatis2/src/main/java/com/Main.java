package com;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/*
作者：梁林
时间：2022-06-06 21:52:16
功能：
*/
public class Main {
    public static void main(String[] args) {
        try {
            //读取配置文件，获得配置文件信息
            InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");
            //通过配置信息创建SqlSessionFactory
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(input);
            //通过SqlSessionFactory打开数据库会话
            SqlSession sqlSession = ssf.openSession();
            //通过SqlSession的selectOne（返回一行记录时使用）方法执行sql语句
            Emp emp = sqlSession.selectOne("getEmpById",1);
            System.out.println(emp);
            //关闭数据库会话
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
