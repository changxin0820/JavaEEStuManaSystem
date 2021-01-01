package com.JavaG.dao;


import com.JavaG.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {



    //根据学院信息获取教师信息
    List<Teacher> getTeacherInfoByAcademyId(Integer academyId);



    //通过教师id获取教师信息
    Teacher getTeacherInfoById(String teacherId);




    //单条插入教师信息
    int insertOneTeacherInfo(Teacher teacher);



    //根据id来删除教师信息
    void deleteTeacherInfo(String id);



    //更新教师信息
    void updateTeacherInfo(Teacher teacher);



}
