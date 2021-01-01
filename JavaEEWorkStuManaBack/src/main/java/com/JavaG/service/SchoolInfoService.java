package com.JavaG.service;


import com.JavaG.domain.Academy;
import com.JavaG.domain.Major;

import java.util.List;

//专业、学院
public interface SchoolInfoService {

    /**
     * 查询所有学院
     * @return
     */
    public List<Academy> findAllAcademies();

    /**
     * 查询所有专业
     * @return
     */
    public List<Major> findAllMajors();


    /**
     * 根据academyId查询所有专业
     * @return
     */
    public List<Major> findMajorsByAcademyId(Integer academyId);


    /**
     * 根据MajorID查询学院
     * @return
     */
    public Academy findAcademyByMajorId(Integer majorId);
}
