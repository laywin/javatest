/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-07-05 14:21 创建
 *
 */
package com.yx.javatest.tmp;

import org.junit.Test;

import java.io.*;

/**
 * @author yanqing@yiji.com
 */
public class SerializableTest {

    @Test
    public void testSerializable() throws Exception {
        File file = new File("D://person.out");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("John");
        oout.writeObject(person);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型
        oin.close();
        System.out.println(newPerson);
    }

    public class Person implements Serializable {

        private String name;

        public Person(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
