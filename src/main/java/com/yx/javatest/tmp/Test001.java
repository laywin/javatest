/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-05-26 18:02 创建
 *
 */
package com.yx.javatest.tmp;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yanqing@yiji.com
 */
public class Test001 {

    @Test
    public void test001() throws UnknownHostException {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        String a = "1/2/3";
//        System.out.println(a.indexOf("/"));
//        Map<String,String> map = Maps.newConcurrentMap();
//        map.put("aa",null);
//        Integer i = Integer.valueOf(5);
//        System.out.println((float)1/(float)2/(float)2);
//          HashMap hashMap = Maps.newHashMap();
//        hashMap.put("hello","world");
        String id = InetAddress.getLocalHost().getHostName() + System.currentTimeMillis();
        System.out.println(id);
    }

    @Test
    public void test002(){
        System.out.println(TestEnum.HELLO.ordinal());
        System.out.println(TestEnum.HELLO1.ordinal());
    }

    @Test
    public void test004() throws ParseException {
        SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

        Long time=new Long(1475913599944L);

        String d = format.format(time);

        System.out.println("Format To String(Date):"+d);
    }


    @Test
    public void test003() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Field[] fields = Person.class.getDeclaredFields();
//        Person person = new Person();
//        for(Field field : fields){
//            field.setAccessible(true);
//            System.out.println(field.get(person));
//        }
//
//        Method method = Person.class.getDeclaredMethod("show");
//        method.setAccessible(true);
//        method.invoke(person);
        Person person = new Person();
//        System.out.println("hello" + person.getFirstname());
    }

//    public static class Person{
//        String firstname;
//
//        public String getFirstname() {
//            return firstname;
//        }
//
//        public void setFirstname(String firstname) {
//            this.firstname = firstname;
//        }
//    }

    @Test
    public void test005(){
        int b = 1;
        int a = b = 3;

        System.out.println(b);

    }

    @Test
    public void test006(){
        TestClass testClass = new TestClass();
        testClass.setField2("aaaa");

        testClass.setField2("bbb");

        System.out.println(testClass.toString());
    }

    @Test
    public void test007() throws ParseException {

        SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

        String d = format.format(1484683340354L);

        Date date=format.parse(d);

        System.out.println("Format To String(Date):"+d);

        System.out.println("Format To Date:"+date);
    }


}
