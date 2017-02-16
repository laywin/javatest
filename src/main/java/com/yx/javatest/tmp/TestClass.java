/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-11-01 15:26 创建
 *
 */
package com.yx.javatest.tmp;

import com.yjf.common.util.ToString;

/**
 * @author yanqing@yiji.com
 */
public class TestClass {

    private String field1;

    private String field2;


    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @ToString.Maskable(maskAll = true)
    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return com.yjf.common.util.ToString.toString(this);
    }
}
