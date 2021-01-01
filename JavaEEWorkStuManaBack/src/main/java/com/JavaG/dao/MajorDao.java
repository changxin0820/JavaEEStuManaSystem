package com.JavaG.dao;

import com.JavaG.domain.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorDao {
    //查询所有专业
    public List<Major> findAllMajors();

    //根据academyId查询所有专业
    public List<Major> findMajorsByAcademyId(Integer academyId);
}
