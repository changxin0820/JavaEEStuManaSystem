package com.JavaG.domain;

/**
 * @author 邓育永
 * @date 2020/12/23 9:40
 */
public class Score {
    private Integer sid;
    private String course;
    private Integer score;

    public Score() {
    }

    public Score(Integer sid, String course, Integer score) {
        this.sid = sid;
        this.course = course;
        this.score = score;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sid=" + sid +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }
}
