package com.dao;

import com.jopo.Emp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmpMapper {
    Emp getEmpById(int id);
    int deleteEmpById(int id);
    int insertEmp(Emp emp);
    int updateEmpById(Emp emp);
    List<Emp> getAllEmp();
    int deleteEmpByIdList(List<Integer> list);
    List<Emp> getEmpByEnameAndJob(HashMap<String,Object> hashMap);
    Map<String,Object> getCount();
}
