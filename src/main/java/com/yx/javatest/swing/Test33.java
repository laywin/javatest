/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-12-15 17:57 创建
 *
 */
package com.yx.javatest.swing;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yanqing@yiji.com
 */
public class Test33 extends JFrame implements ActionListener {
    JButton open = null;

    public static void main(String[] args) {
        new Test33();
    }

    public Test33() {
        open = new JButton("open");
        this.add(open);
        this.setBounds(400, 200, 100, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        open.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        if (null != file) {
            if (file.isDirectory()) {
                System.out.println("文件夹:" + file.getAbsolutePath());
            } else if (file.isFile()) {
                System.out.println("文件:" + file.getAbsolutePath());
            }

            System.out.println(jfc.getSelectedFile().getName());
        }


    }

    @Test
    public void test001() throws ParseException {
        SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );


        String d = format.format(1482819382721L);

        Date date=format.parse(d);

        System.out.println("Format To String(Date):"+d);

        System.out.println("Format To Date:"+date);
    }
}
