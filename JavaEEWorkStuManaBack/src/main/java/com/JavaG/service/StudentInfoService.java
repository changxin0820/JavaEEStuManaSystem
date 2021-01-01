package com.JavaG.service;

import com.JavaG.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentInfoService {

    /**
     * 查找所有
     * @return
     */
    List<Student> findAll();


    /**
     * 根据专业id获取学生信息
     * @param majorName
     * @return
     */
    List<Student> findStudentByMajorName(String majorName);


    /**
     * 根据学院id获取学生信息
     * @param academyName
     * @return
     */
    List<Student> findStudentByAcademyName(String academyName);




    /**
     * 根据学生id获取学生详细信息
     * @param id
     * @return
     */
    Student findStudentDetailsById(Integer id);


    /**
     * 根据id获取学生信息
     * @param id
     * @return
     */
    List<Student> findStudentById(Integer id);


    /**
     * 单条插入学生信息
     * @param student
     * @return
     */
    Boolean insertOneStudentInfo(Student student);



    /**
     * 根据id来删除学生信息
     * @param student
     */
    Boolean deleteStudentInfo(Student student);

    Integer findStudentByidCard(String idCard);
    /**
     * 更新学生信息
     * @param student
     */
    Boolean updateStudentInfo(Student student);
}
