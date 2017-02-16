/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2017-01-19 16:38 创建
 *
 */
package com.yx.javatest.lucene;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author yanqing@yiji.com
 */
public class DocumentDeleteTest extends BaseIndexingTestCase {

     public void testDelete() throws IOException {
         String dir = "";
         Directory directory = FSDirectory.open(Paths.get(dir));
         IndexReader indexReader = DirectoryReader.open(directory);


     }
}
