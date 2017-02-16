/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-08-22 16:31 创建
 *
 */
package com.yx.javatest.automaton;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;
import dk.brics.automaton.RunAutomaton;
import org.junit.Before;
import org.junit.Test;

/**
 * @author yanqing@yiji.com
 */
public class AutomatonTest {

//    private Automaton MONITOR_AUTOMATON;
            //Automatons.patterns(new String[] { "cluster:monitor/*" });

//    @Before
//    public void setUp(){
//        MONITOR_AUTOMATON = toAutomaton("cluster:monitor/*");
//    }

    @Test
    public void test001(){
//        if(MONITOR_AUTOMATON.run("cluster:monitor/bb")){
//            System.out.println("cc");
//        }
        RunAutomaton cc = toAutomaton("cluster:monitor*");
        if(cc.run("cluster:monitorf")){
            System.out.println("cc");
        }
    }

    public static RunAutomaton toAutomaton(String regex){
        return new RunAutomaton(new RegExp(regex).toAutomaton(),false);
    }
}
