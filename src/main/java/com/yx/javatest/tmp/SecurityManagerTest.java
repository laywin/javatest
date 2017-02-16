/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-07-22 15:12 创建
 *
 */
package com.yx.javatest.tmp;

import org.junit.Test;

import java.security.Security;

/**
 * @author yanqing@yiji.com
 */
public class SecurityManagerTest {

    @Test
    public void test001(){
        SecurityManager sm = System.getSecurityManager();
//        sm.checkPackageAccess();
        String pkgAccess = Security.getProperty("package.access");

        System.out.println(pkgAccess);
    }

}
