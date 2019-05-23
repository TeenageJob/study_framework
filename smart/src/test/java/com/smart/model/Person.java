package com.smart.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2014-06-04.
 */
public class Person implements Serializable {
    /**
	 * create by ty on TY 2017年11月10日 下午2:22:34
	 */
	private static final long serialVersionUID = -2250143803747154146L;
	private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
