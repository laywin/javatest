/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2016-12-15 20:52 创建
 *
 */
package com.yx.javatest.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author yanqing@yiji.com
 */
public class MainForm extends JFrame {


    private static final long serialVersionUID = 1L;
    /* 主窗体里面的若干元素 */
    private JFrame mainForm = new JFrame("总表生成器");
    private JLabel label1 = new JLabel("请选择户表所在的文件夹：");
    private JLabel label2 = new JLabel("请选择一个空的总表：");
    public static JTextField detailInput = new JTextField();
    public static JTextField summaryInput = new JTextField();
    public static JButton buttonBrowseDetail = new JButton("浏览");
    public static JButton buttonBrowseSummary = new JButton("浏览");
    public static JButton buttonEncrypt = new JButton("生成总表");

    public MainForm() {
        Container container = mainForm.getContentPane();

        /* 设置主窗体属性 */
        mainForm.setSize(400, 270);// 设置主窗体大小
        mainForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 设置主窗体关闭按钮样式
        mainForm.setLocationRelativeTo(null);// 设置居于屏幕中央
        mainForm.setResizable(false);// 设置窗口不可缩放
        mainForm.setLayout(null);
        mainForm.setVisible(true);// 显示窗口

        /* 设置各元素位置布局 */
        label1.setBounds(30, 10, 300, 30);
        detailInput.setBounds(50, 50, 200, 30);
        buttonBrowseDetail.setBounds(270, 50, 60, 30);
        label2.setBounds(30, 90, 300, 30);
        summaryInput.setBounds(50, 130, 200, 30);
        buttonBrowseSummary.setBounds(270, 130, 60, 30);
        buttonEncrypt.setBounds(85, 180, 150, 30);

        buttonBrowseDetail.addActionListener(new DetailAction());
        buttonBrowseSummary.addActionListener(new SummaryAction());

        detailInput.setEditable(false);
        summaryInput.setEditable(false);

        container.add(label1);
        container.add(label2);
        container.add(detailInput);
        container.add(summaryInput);
        container.add(buttonBrowseDetail);
        container.add(buttonBrowseSummary);
        container.add(buttonEncrypt);
    }

    public static void main(String args[]) {
        new MainForm();
    }

}
