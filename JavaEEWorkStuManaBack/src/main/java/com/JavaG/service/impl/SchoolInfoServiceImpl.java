package com.JavaG.service.impl;

import com.JavaG.dao.AcademyDao;
import com.JavaG.dao.MajorDao;
import com.JavaG.domain.Academy;
import com.JavaG.domain.Major;
import com.JavaG.service.SchoolInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service()
public class SchoolInfoServiceImpl implements SchoolInfoService {

    @Resource
    private AcademyDao academyDao;
    @Resource
    private MajorDao majorDao;

    @Override
    public List<Academy> findAllAcademies() {
        System.out.println("service查询所有院系");
        List<Academy> academies=academyDao.findAllAcademies();
        for(Academy academy:academies){
            System.out.println(academy);
        }
        return academies;
    }

    @Override
    public List<Major> findAllMajors() {
        System.out.println("service查询所有专业");
        List<Major> majors=majorDao.findAllMajors();
        for(Major major:majors){
            System.out.println(major);
        }
        return majors;
    }

    @Override
    public List<Major> findMajorsByAcademyId(Integer academyId) {
        System.out.println("service查询所有专业");
        List<Major> majors=majorDao.findMajorsByAcademyId(academyId);
        for(Major major:majors){
            System.out.println(major);
        }
        return majors;
    }

    @Override
    public Academy findAcademyByMajorId(Integer majorId) {
        System.out.println("service查询所有院系");
        Academy academy=academyDao.findAcademyByMajorId(majorId);
        System.out.println(academy);
        return academy;
    }
}
