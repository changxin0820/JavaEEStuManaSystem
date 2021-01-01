package com.JavaG.service;

import com.JavaG.domain.Course;
import com.JavaG.domain.SC;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {
    List<Course> findAllCourseByStudentId(int id);
    Boolean deleteStudentCourse(SC sc);
    Boolean createCourse(Course course);
    Boolean selectCourse(SC sc);
    List<Course> findAllCourse();
}
