package com.JavaG.domain;

/**
 * @author 邓育永
 * @date 2020/12/17 0:52
 */
public class ReportCard {
    private Integer index;
    private Integer sid;
    private  String name;
    private Object performance;

    public ReportCard() {
    }

    public ReportCard(Integer index, Integer sid, String name, Object performance) {
        this.index = index;
        this.sid = sid;
        this.name = name;
        this.performance = performance;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPerformance() {
        return performance;
    }

    public void setPerformance(Object performance) {
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "index=" + index +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                ", performance=" + performance +
                '}';
    }
}
