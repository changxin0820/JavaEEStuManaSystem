package com.JavaG.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable {

    private Integer id;//职工号
    private String name;//姓名
    private String sex;//性别
    private String nation;//民族
    private String politicsStatus;//政治面貌
    private String idCard;//身份证号
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//入职时间
    private String phoneNum;//电话号码
    private Integer age;//年龄
    private Major major;//专业
    private Academy academy;//学院



}
