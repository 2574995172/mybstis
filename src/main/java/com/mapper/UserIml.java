package com.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.popj.User;
import java.io.InputStream;

/*
作者：梁林
时间：2022-06-06 19:51:24
功能：
*/
public class UserIml implements UserMapper {
    private static SqlSessionFactory ssf;
    static {
        try {
            //读取配置文件，获得配置文件信息
            InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");
            //通过配置信息创建SqlSessionFactory
            ssf = new SqlSessionFactoryBuilder().build(input);
            //通过SqlSessionFactory打开数据库会话
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public User juqerUser(int id){
        SqlSession sqlSession = ssf.openSession();
        //通过SqlSession的selectOne（返回一行记录时使用）方法执行sql语句
        User user=sqlSession.selectOne("getUserById",id);
        //关闭数据库会话
        sqlSession.close();
        return user;
    }
}
