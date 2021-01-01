package com.JavaG.service;

import com.JavaG.domain.Teacher;

import java.util.List;

public interface TeacherService {

    /**
     *根据学院信息获取教师信息
     * @param academyId
     * @return
     */
    List<Teacher> getTeacherInfoByAcademyId(Integer academyId);


    /**
     *通过教师id获取教师信息
     * @param teacherId
     * @return
     */
    Teacher getTeacherInfoById(String teacherId);



    /**
     * 单条插入教师信息
     * @param teacher
     * @return
     */
    int insertOneTeacherInfo(Teacher teacher);



    /**
     * 根据id来删除教师信息
     * @param id
     */
    void deleteTeacherInfo(String id);



    /**
     * 更新教师信息
     * @param teacher
     */
    void updateTeacherInfo(Teacher teacher);
}
