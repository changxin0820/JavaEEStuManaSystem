package com.JavaG.dao;


import com.JavaG.domain.Student;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface StudentDao {



    //查询所有
//    @Select("select * from student")
    List<Student> findAll();


    //根据专业id获取学生信息
//    @Select("select * from student where majorId = #{majorId}")
    List<Student> findStudentByMajorName(String majorName);



    //根据学院id获取学生信息
//    @Select("select * from student where academyId = #{academyId}")
    List<Student> findStudentByAcademyName(String academyName);

    Integer findStudentByidCard(String idCard);



    //根据学生id获取学生详细信息
//    @Select("select * from student where id = #{id}")
    Student findStudentDetailsById(Integer id);


    List<Student> findStudentById(Integer id);

    //单条插入学生信息
//    @Insert("insert into student values(#{id},#{name},#{sex},#{nation},#{politicsStatus},#{idCard},#{majorId},#{academyId},{class},#{phoneNum},#{birth},#{nativePlace})")
    Boolean insertOneStudentInfo(Student student);




    //根据id来删除学生信息
//    @Delete("delete from student where id = #{id}")
    Boolean deleteStudentInfo(Student student);




    //更新学生信息
//    @Update("update student set name = #{name},sex = #{sex},nation = #{nation},politicsStatus = #{politicsStatus},idCard = #{idCard},majorId = #{majorId},academyId = #{academyId},class = {class},phoneNum = #{phoneNum},birth = #{birth},nativePlace=#{nativePlace} where id = #{student.id}")
    Boolean updateStudentInfo(Student student);



}
