/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2017-02-10 16:59 创建
 *
 */
package com.yx.javatest.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author yanqing@yiji.com
 */
public class MyAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        TokenStreamComponents tsc = new TokenStreamComponents(new WhitespaceTokenizer());
        return tsc;
    }

    public static void main(String[] args) throws IOException {
         MyAnalyzer myAnalyzer = new MyAnalyzer();

         TokenStream tokenStream = myAnalyzer.tokenStream("greeting",new StringReader("welcome back to school"));

         CharTermAttribute cta = tokenStream.addAttribute(CharTermAttribute.class);

        try{
            tokenStream.reset();
            while(tokenStream.incrementToken()){
                 System.out.println(cta.toString());
            }

        }finally{
            tokenStream.close();
        }

    }

}
