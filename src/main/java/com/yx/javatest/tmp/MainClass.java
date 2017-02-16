/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-10-19 14:00 创建
 *
 */
package com.yx.javatest.tmp;

/**
 * @author yanqing@yiji.com
 */
public class MainClass {


    public  void print(){
        NestClass nestClass = new NestClass();
        nestClass.setField1("hello");
        nestClass.setField2("world");

        System.out.println(nestClass.getField1() + " " + nestClass.getField2());
    }

    static class NestClass{
        private String field1;

        private String field2;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }
    }
}
