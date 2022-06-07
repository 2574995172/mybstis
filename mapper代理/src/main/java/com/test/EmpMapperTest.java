package com.test;

import com.dao.EmpMapper;
import com.jopo.Emp;
import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
作者：梁林
时间：2022-06-07 09:34:22
功能：
*/
public class EmpMapperTest {
    private static SqlSessionFactory ssf;
    static {
        InputStream input = null;
        try {
            input = Resources.getResourceAsStream("SqlMapConfig.xml");
            ssf = new SqlSessionFactoryBuilder().build(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession=ssf.openSession();
        EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);

        //使用Map接收结果
        Map<String,Object> map=empMapper.getCount();
        System.out.println(map);

        /*
        //使用Map作为参数
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("ename","李华");
        hashMap.put("job","店员");
        List<Emp> list=empMapper.getEmpByEnameAndJob(hashMap);
        for(Emp emp:list){
            System.out.println(emp);
        }
         */

        /*
        //使用list作为参数
        List<Integer> listId=new ArrayList<>();
        listId.add(1);
        listId.add(2);
        listId.add(3);
        int row=empMapper.deleteEmpByIdList(listId);
        System.out.println(row);
         */

        /*
        //使用list接收实体类
        List<Emp> emps=empMapper.getAllEmp();
        for (Emp emp:emps){
            System.out.println(emp);
        }
         */

        /*
        //使用单个参数
        Emp e= empMapper.getEmpById(1);
        System.out.println(e);

        int row=empMapper.deleteEmpById(1);
        System.out.println(row);
        */

        /*
        //使用实体类对象作为参数
        Emp empUp=new Emp();
        empUp.setHiredate("2022-06-07");
        empUp.setEname("赵四");
        empUp.setJob("老板");
        empUp.setSal(12000.00);
        empUp.setDeptno(30);
        int r=empMapper.updateEmpById(empUp);
        System.out.println(r);
         */

        sqlSession.commit();
        sqlSession.close();
    }
}
