package com.jopo;

import lombok.Data;

/*
作者：梁林
时间：2022-06-07 09:30:38
功能：
*/
@Data
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private String hiredate;
    private Double sal;
    private Integer deptno;
}
