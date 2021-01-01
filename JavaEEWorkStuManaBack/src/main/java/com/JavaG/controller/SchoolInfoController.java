package com.JavaG.controller;


import com.JavaG.domain.Academy;
import com.JavaG.domain.Major;
import com.JavaG.service.SchoolInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/schoolInfo",produces = {"application/json;charset=UTF-8"})
public class SchoolInfoController {

    @Autowired
    private SchoolInfoService schoolInfoService;


    @RequestMapping(value = "/findAllAcademies",method = {RequestMethod.GET})
    public List<Academy> findAllAcademies() {
        System.out.println("controller：查询所有学院...");
        // 调用service的方法
        List<Academy> academies = schoolInfoService.findAllAcademies();
        for(Academy academy:academies){
            System.out.println(academy);
        }
        return academies;
    }

    @RequestMapping(value = "/findAllMajors", method = {RequestMethod.GET})
    public List<Major> findAllMajors() {
        System.out.println("controller:allMajors");
        List<Major> majors=schoolInfoService.findAllMajors();
        for(Major major:majors){
            System.out.println(major);
        }
        return majors;
    }


    @RequestMapping(value = "/findMajorsByAcademyId", method = {RequestMethod.POST})
    public List<Major> findMajorsByAcademyId(@RequestBody Academy academy){
        System.out.println(academy);
        Integer academyId=academy.getId();
        List<Major> majors=schoolInfoService.findMajorsByAcademyId(academyId);
        for(Major major:majors){
            System.out.println(major);
        }
        return majors;
    }


    @RequestMapping(value = "/findAcademyByMajorId", method = {RequestMethod.POST})
    public Academy findAcademyByMajorId(@RequestBody Major major){
        System.out.println(major);
        Integer majorId=major.getId();
        Academy academy=schoolInfoService.findAcademyByMajorId(majorId);
        System.out.println(academy);
        return academy;
    }

}
