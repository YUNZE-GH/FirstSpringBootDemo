package com.gh.firstdemo.entity;

import java.io.Serializable;

/**
 * @author gaohan
 * @version 1.0
 * @date 2020/8/1 9:38
 */
public class Student implements Serializable {
    private static final long seriaVersionUID = 1L;
    private String id;
    private String name;

    public Student(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
