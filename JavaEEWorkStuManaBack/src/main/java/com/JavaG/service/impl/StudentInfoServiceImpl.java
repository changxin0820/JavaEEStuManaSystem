package com.JavaG.service.impl;

import com.JavaG.dao.StudentDao;
import com.JavaG.dao.UserDao;
import com.JavaG.domain.Student;
import com.JavaG.domain.User;
import com.JavaG.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service()
public class StudentInfoServiceImpl implements StudentInfoService {

    @Resource
    private StudentDao studentDao;
    @Resource
    private UserDao userDao;


    @Override
    public List<Student> findAll() {

        System.out.println("业务层：查询所有学生1...");
        return studentDao.findAll();
    }

    @Override
    public List<Student> findStudentByMajorName(String majorName) {

        return studentDao.findStudentByMajorName(majorName);
    }

    @Override
    public List<Student> findStudentByAcademyName(String academyName) {
        return studentDao.findStudentByAcademyName(academyName);
    }

    @Override
    public Student findStudentDetailsById(Integer id) {
        System.out.println("studentInfoImpl");
        return studentDao.findStudentDetailsById(id);
    }

    @Override
    public List<Student> findStudentById(Integer id) {
        return studentDao.findStudentById(id);
    }

    @Override
    public Boolean insertOneStudentInfo(Student student) {

        if (student.getName()!=null) {
           Boolean isTrue= studentDao.insertOneStudentInfo(student);
            String idCard=student.getIdCard();
            Integer id=studentDao.findStudentByidCard(idCard);
            String username=student.getName();
            User user =new User();
            user.setId(id);
            user.setPassword("123456");
            user.setStatus(1);
            user.setType(1);
            user.setUsername(username);
            Boolean isSuccessed= userDao.insertUser(user);
            if(isTrue && isSuccessed)
            {
                return true;
            }
            else {
                return false;
            }





        }
        else {
            return false;
        }

    }

    @Override
    public Boolean deleteStudentInfo(Student student) {

        if(studentDao.findStudentDetailsById(student.getId())!=null){
            return studentDao.deleteStudentInfo(student);
        }
        return false;
    }

    @Override
    public Integer findStudentByidCard(String idCard) {
        return studentDao.findStudentByidCard(idCard);
    }


    @Override
    public Boolean updateStudentInfo(Student student) {

        if(studentDao.findStudentDetailsById(student.getId())!=null){
            return studentDao.updateStudentInfo(student);
        }
        return false;

    }
}
