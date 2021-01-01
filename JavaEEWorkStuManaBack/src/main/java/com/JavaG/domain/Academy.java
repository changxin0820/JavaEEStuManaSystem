package com.JavaG.domain;

import java.io.Serializable;
import java.util.List;

public class Academy implements Serializable {

    private Integer id;//学院id

    private String name;//学院名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Academy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
