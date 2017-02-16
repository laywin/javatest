/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2017-01-19 16:04 创建
 *
 */
package com.yx.javatest.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Before;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author yanqing@yiji.com
 */
public abstract class BaseIndexingTestCase{
     protected String[] keywords = {"1","2"};

     protected String[] unindexed = {"Netherlands","Italy"};

     protected String[] unstored = {"Amsterdam has lots of bridges","Venice has lots of canals"};

     protected String[] text = {"Amsterdam","Venice"};

     protected Directory dir;

     @Before
     public void before(){
         String indexDir = "";

         try {
             dir = FSDirectory.open(Paths.get(indexDir));
             addDocuments(dir);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

    protected void addDocuments(Directory dir){
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(getAnalyzer());
        try {
            IndexWriter indexWriter = new IndexWriter(dir,indexWriterConfig);

            for(int i = 0;i < keywords.length;++i){
                Document document = new Document();

                document.add(new StringField("contents",unstored[i], Field.Store.NO));

                document.add(new TextField("city",text[i],Field.Store.YES));
            }
            indexWriter.forceMerge(1);
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected Analyzer getAnalyzer(){
        return new StandardAnalyzer();
    }

    protected boolean isCompound(){
        return true;
    }



}
