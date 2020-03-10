package edu.nustti.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LemonCCC
 * @description
 * @create 2020/1/3  21:57
 */
@Data
public class Student implements Serializable {
    private String name;
    private Integer age;
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public Student(){

    }
}
