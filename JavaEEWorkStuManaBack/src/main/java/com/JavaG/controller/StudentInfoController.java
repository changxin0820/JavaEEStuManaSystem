package com.JavaG.controller;


import com.JavaG.domain.Account;
import com.JavaG.domain.Student;
import com.JavaG.service.StudentInfoService;
import com.JavaG.service.impl.StudentInfoServiceImpl;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping(value = "/api/studentInfo",produces = {"application/json;charset=UTF-8"})
public class StudentInfoController {


    @Autowired
    private StudentInfoService studentInfoService;



    /**
     * 查找所有
     * @return
     */
    @RequestMapping(value = "/findAll",method = {RequestMethod.POST})
    public List<Student> findAll(){
        System.out.println("表现层：查询所有学生...");
        List<Student> students = studentInfoService.findAll();
        for(Student student:students){
            System.out.println(student);
        }
        return students;
    }


    /**
     * 根据专业id获取学生信息
     * @param majorName
     * @return
     */
    @RequestMapping(value = "/findStudentByMajorName",method = {RequestMethod.POST})
    public List<Student> findStudentByMajorName(@RequestBody String majorName){


        JSONObject jsonObj = new JSONObject(majorName);

        System.out.println(jsonObj.get("majorName"));
        String name=jsonObj.get("majorName").toString();

        return studentInfoService.findStudentByMajorName(name);
    }


    /**
     * 根据学院id获取学生信息
     * @param academyName
     * @return
     */
    @RequestMapping(value = "/findStudentByAcademyName",method = {RequestMethod.POST})
    public List<Student> findStudentByAcademyName(@RequestBody String academyName){
        System.out.println(academyName);
        JSONObject jsonObj = new JSONObject(academyName);

        System.out.println(jsonObj.get("academyName"));
        String name=jsonObj.get("academyName").toString();
        return studentInfoService.findStudentByAcademyName(name);
    }




    /**
     * 根据学生id获取学生详细信息
     * @param
     * @return
     */

    @RequestMapping(value = "/findStudentDetailsById",method = {RequestMethod.POST})
    public  Student findStudentDetailsById(@RequestBody Student student){
        System.out.println("studentInfoController");
//        JSONObject object = new JSONObject();
        Integer id=student.getId();
        Student stu=studentInfoService.findStudentDetailsById(id);
//        object.put("student", stu);

        System.out.println(stu);
        return stu;
    }

    @RequestMapping(value = "/findStudentById",method = {RequestMethod.POST})
    public List<Student> findStudentById(@RequestBody Student student){
        Integer id=student.getId();
        List<Student> stu=studentInfoService.findStudentById(id);
        return stu;
    }


    /**
     * 单条插入学生信息
     * @param student
     * @return
     */
    @RequestMapping(value = "/insertOneStudentInfo",method = {RequestMethod.POST})
    public Boolean insertOneStudentInfo(@RequestBody Student student)  {

        return studentInfoService.insertOneStudentInfo(student);




    }



    /**
     * 根据id来删除学生信息
     * @param student
     */
    @RequestMapping(value = "/deleteStudentInfo",method = {RequestMethod.POST})
    public Boolean deleteStudentInfo(@RequestBody Student student){
        return studentInfoService.deleteStudentInfo(student);

    }



    /**
     * 更新学生信息
     * @param student
     */
    @RequestMapping(value = "/updateStudentInfo",method = {RequestMethod.POST})
    public Boolean updateStudentInfo(@RequestBody Student student){

        return studentInfoService.updateStudentInfo(student);

    }

}
