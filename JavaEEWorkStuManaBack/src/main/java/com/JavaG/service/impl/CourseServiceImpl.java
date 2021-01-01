package com.JavaG.service.impl;

import com.JavaG.dao.CourseDao;
import com.JavaG.domain.Course;
import com.JavaG.domain.SC;
import com.JavaG.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao courseDao;
    @Override
    public List<Course> findAllCourseByStudentId(int id) {
        return courseDao.findAllCourseByStudentId(id);
    }

    @Override
    public Boolean deleteStudentCourse(SC sc) {
        return courseDao.deleteStudentCourse(sc);
    }

    @Override
    public Boolean createCourse(Course course) {
        return courseDao.createCourse(course);
    }

    @Override
    public Boolean selectCourse(SC sc) {
        return courseDao.selectCourse(sc);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseDao.findAllCourse();
    }
}
