package com.JavaG.dao;

import com.JavaG.domain.Academy;
import com.JavaG.domain.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcademyDao {

    //查询所有院系
    public List<Academy> findAllAcademies();

    //根据MajorID查询学院
    public Academy findAcademyByMajorId(Integer majorId);

}
