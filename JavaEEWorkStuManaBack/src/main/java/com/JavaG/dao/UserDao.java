package com.JavaG.dao;

import com.JavaG.domain.Student;
import com.JavaG.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

//与数据库交互，表user_login，
@Repository
public interface UserDao {

/*    //根据用户名和密码查询单个
    //@Select("select * from user_login where username = #{username} and password = #{password} ")
    User getUser(@Param("username") String username, @Param("password")String password);*/


    User getUser(User user);


    //根据用户名修改用户密码
    //@Update("update user_login set password = #{newPass} where username = #{username}")
    void updatePass(@Param("id") int id, @Param("newPass") String newPass);

    //查找用户
    //@Select("select * from user_login where id = #{id}")
    User getUserById(int id);

    //更新用户状态，0为被禁用，1为正常
    void updateUserStatus(@Param("id")int id, @Param("status")int status);

    //获得所有学生信息
    ArrayList<Student> getAllUsers();
    Boolean insertUser(User user);

}




