/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-05-30 18:57 创建
 *
 */
package com.yx.javatest.tmp;

/**
 * @author yanqing@yiji.com
 */
public class Person {

    private String firstName = "zhangsan";

    private String lastName;

    public Person(){

    }

    private void show(){
        System.out.println("private show method!");
    }

    public static Baby createBaby(int age){
        return new Baby(10);
    }


    private static class Baby extends Person{

        public Baby(int age){
            this.age = age;
        }

        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
}
