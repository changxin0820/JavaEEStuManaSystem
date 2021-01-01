package com.JavaG.domain;

import java.io.Serializable;

public class SC implements Serializable {

    private Integer sId;   //学生
    private Integer cId;   //课程
    private Integer grade;  //成绩

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
