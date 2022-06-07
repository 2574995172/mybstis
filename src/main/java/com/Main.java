package com;
import com.mapper.UserIml;
import com.popj.User;

import java.sql.SQLException;

/*
作者：梁林
时间：2022-06-06 19:40:15
功能：
*/
public class Main {
    public static void main(String[] args) throws SQLException {
        UserIml userIml=new UserIml();
        User user=userIml.juqerUser(1);
        System.out.println(user);
    }
}
