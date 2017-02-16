/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-06-27 11:48 创建
 *
 */
package com.yx.javatest.beaninfo;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author yanqing@yiji.com
 */
public class BeanInfoTest {

    @Test
    public void testBeanInfo() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor pd : propertyDescriptors){
            int a = 1;
        }
    }
}
