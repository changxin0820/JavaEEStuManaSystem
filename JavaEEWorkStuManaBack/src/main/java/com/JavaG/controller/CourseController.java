package com.JavaG.controller;

import com.JavaG.domain.Account;
import com.JavaG.domain.Course;
import com.JavaG.domain.SC;
import com.JavaG.domain.Student;
import com.JavaG.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/course",produces = {"application/json;charset=UTF-8"})
public class CourseController {
    @Resource
    private CourseService courseService;

    @RequestMapping(value = "/findAllCourseByStudentId",method = RequestMethod.POST)
    public List<Course> findAllCourseByStudentId(@RequestBody  Course course){
        // 调用service的方法

        int id=course.getId();

        List<Course> list = courseService.findAllCourseByStudentId(id);
        System.out.println(list);
        return list;



    }
    @RequestMapping(value = "/deleteStudentCourse",method = RequestMethod.POST)
    public Boolean deleteStudentCourse(@RequestBody SC sc){
        // 调用service的方法

        Boolean isSuccessed = courseService.deleteStudentCourse(sc);
        return isSuccessed;
    }
    @RequestMapping(value = "/createCourse",method = RequestMethod.POST)
    public Boolean createCourse(@RequestBody Course course){
        // 调用service的方法

        Boolean isSuccessed = courseService.createCourse(course);
        return isSuccessed;
    }
    @RequestMapping(value = "/selectCourse",method = RequestMethod.POST)
    public Boolean selectCourse(@RequestBody SC sc){
        // 调用service的方法

        Boolean isSuccessed = courseService.selectCourse(sc);
        return isSuccessed;
    }
    @RequestMapping(value = "/findAllCourse",method = RequestMethod.GET)
    public List<Course> findAllCourse(){
        // 调用service的方法

        List<Course> list = courseService.findAllCourse();
        return list;
    }

}
