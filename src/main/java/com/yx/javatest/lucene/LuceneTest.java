/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * yanqing@yiji.com 2017-01-18 10:04 创建
 *
 */
package com.yx.javatest.lucene;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.CharsRefBuilder;
import org.apache.lucene.util.PagedBytes;
import org.apache.lucene.util.Version;

import java.io.*;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author yanqing@yiji.com
 */
public class LuceneTest {

    @Test
    public void test1() throws Exception {
        Analyzer analyzer = new StandardAnalyzer();
        Directory directory = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(directory, config);
        Document document = new Document();
        String text = "this is the text to be indexed.";
        document.add(new Field("fieldName", text, TextField.TYPE_STORED));
        writer.addDocument(document);
        writer.close();
        // Now search the index:
        DirectoryReader ireader = DirectoryReader.open(directory);
        IndexSearcher isearcher = new IndexSearcher(ireader);
        // Parse a simple query that searches for "text":
        QueryParser parser = new QueryParser("fieldname", analyzer);
        Query query = parser.parse("text");
        ScoreDoc[] hits = isearcher.search(query, 1000).scoreDocs;
        assertEquals(1, hits.length);
        // Iterate through the results:
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = isearcher.doc(hits[i].doc);
            System.out.println(hitDoc.get("fieldname"));
//            assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
        }
        ireader.close();
        directory.close();
    }

    @Test
    public void test2() {
        Version version = Version.LUCENE_6_3_0;

        Analyzer analyzer = new StandardAnalyzer();

        TokenStream ts = analyzer.tokenStream("myfield", new StringReader("some text goes here"));

        OffsetAttribute offsetAttribute = ts.addAttribute(OffsetAttribute.class);

        try {
            ts.reset();
            while (ts.incrementToken()) {
                System.out.println("token:" + ts.reflectAsString(true));

                System.out.println("token start offset: " + offsetAttribute.startOffset());
                System.out.println("  token end offset: " + offsetAttribute.endOffset());
            }

            ts.end();
        } catch (Exception e) {
        } finally {
            try {
                ts.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test3() throws IOException {
        Analyzer analyzer = new StandardAnalyzer();

        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        Directory directory = new SimpleFSDirectory(Paths.get("D:\\luceneindex"));

        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        File luceneData = new File("D:\\lucenedoc");
        File[] files = luceneData.listFiles();
        assertNotNull(files);

        for (int i = 0; i < files.length; ++i) {
            if (files[i].isFile() && files[i].getName().endsWith(".txt")) {
                Document document = new Document();
                document.add(new StringField("path", files[i].getCanonicalPath(), Field.Store.YES));
                Reader txtReader = new FileReader(files[i]);
                document.add(new Field("content", txtReader, new FieldType()));
                indexWriter.addDocument(document);
            }
        }

        indexWriter.close();
        directory.close();
    }

    @Test
    public void test4() throws IOException {
        //search
        RAMDirectory ramDirectory = new RAMDirectory();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig();
        //index
        IndexWriter indexWriter = new IndexWriter(ramDirectory, indexWriterConfig);

        Document document = new Document();

        FieldType fieldType = new FieldType();

        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);

        document.add(new Field("item", "hello zhang san", fieldType));

        Document document1 = new Document();

        document.add(new Field("item1", "zhang zhang is student", fieldType));

        indexWriter.addDocument(document);

        indexWriter.addDocument(document1);

        indexWriter.commit();
        indexWriter.close();

        IndexReader indexReader = DirectoryReader.open(ramDirectory);

//        int numDocs = indexReader.numDocs();

//        System.out.println(numDocs);

//        List<LeafReaderContext> list = indexReader.leaves();
//
//        for(LeafReaderContext context : list){
//            LeafReader leafReader = context.reader();
//
//            leafReader.getFieldInfos().iterator();
//        }
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        Query query = new TermQuery(new Term("item", "zhang"));
        TopScoreDocCollector collector = TopScoreDocCollector.create(10);
        indexSearcher.search(query, collector);

        TopDocs topDocs = collector.topDocs();
//        TopFieldDocs topDocs = indexSearcher.search(query,10,Sort.INDEXORDER);
//        for(int i = 0;i < topDocs.scoreDocs.length;++i){
//            System.out.println("id: " + topDocs.scoreDocs[i].doc);
//
//            Document document1 = indexSearcher.doc(topDocs.scoreDocs[i].doc);
//            Iterator<IndexableField> iterator = document1.iterator();
//            while(iterator.hasNext()){
//                IndexableField field = iterator.next();
//
//                System.out.println("name: " + field.name() + " value: " + field.stringValue());
//            }
//        }
//        SortField[] fields = topDocs.fields;
//        for(int i = 0;i < fields.length;++i){
//            System.out.println(fields[i].getField());
//            System.out.println(fields[i].toString());
//        }

        ramDirectory.close();
        indexReader.close();
    }

    @Test
    public void test5() throws IOException {
        Analyzer analyzer = new StandardAnalyzer();

        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        Directory directory = new SimpleFSDirectory(Paths.get("c:\\lucene"));

        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        FieldType fieldType = new FieldType();
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
        fieldType.setStored(true);
        fieldType.setTokenized(true);
        fieldType.setStoreTermVectors(true);

        Document document = new Document();

        document.add(new Field("item", "hello zhang san", fieldType));

        Document document1 = new Document();
        document1.add(new Field("item", "zhang zhang is student", fieldType));

        indexWriter.addDocument(document);
        indexWriter.addDocument(document1);
        indexWriter.commit();
        indexWriter.close();
    }

    @Test
    public void test6() throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get("c:\\lucene"));
        IndexReader indexReader = DirectoryReader.open(directory);
        Query query = new TermQuery(new Term("item", "zhang"));
//        Query query1 = new TermQuery(new Term("item", "student"));
        BooleanClause must_zhang = new BooleanClause(query, BooleanClause.Occur.MUST);
//        BooleanClause not_student = new BooleanClause(query1, BooleanClause.Occur.MUST_NOT);
        BooleanQuery booleanQuery = new BooleanQuery.Builder().add(must_zhang).build();


        Terms terms = indexReader.getTermVector(1, "item");

        TermsEnum termsEnum = terms.iterator();
        CharsRefBuilder spare = new CharsRefBuilder();
        BytesRef text;
        while ((text = termsEnum.next()) != null) {
            spare.copyUTF8Bytes(text);
            String term = spare.toString();
            System.out.println("term: " + term + " docFreq: " + termsEnum.docFreq());
        }

        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        Explanation explanation = indexSearcher.explain(booleanQuery, 1);


        System.out.println(explanation.toString());

        TopScoreDocCollector collector = TopScoreDocCollector.create(10);

        indexSearcher.search(booleanQuery, collector);

        TopDocs topDocs = collector.topDocs();

        for (int i = 0; i < topDocs.scoreDocs.length; ++i) {
            Document document = indexReader.document(topDocs.scoreDocs[i].doc);
            System.out.println("id: " + topDocs.scoreDocs[i].doc);
            System.out.println("term: " + document.get("item"));
        }

    }

    @Test
    public void test7() throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get("c:\\lucene"));
        IndexReader indexReader = DirectoryReader.open(directory);

        Terms terms = indexReader.getTermVector(1, "item");

        TermsEnum termsEnum = terms.iterator();

        TermState termState = termsEnum.termState();

//        int docNumbersWithTerm = indexReader.docFreq(new Term(termsEnum.term(), "item"));
//        System.out.println(docNumbersWithTerm);


    }

    @Test
    public void test8() throws IOException {
        StandardAnalyzer standardAnalyzer = new StandardAnalyzer();
        TokenStream tokenStream = standardAnalyzer.tokenStream("myfield", new StringReader("welcome back to school"));
        OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);

        try {
            tokenStream.reset();

            while (tokenStream.incrementToken()) {
                System.out.println("token: " + tokenStream.reflectAsString(true));
                System.out.println("start offset: " + offsetAttribute.startOffset() + " end offset: " + offsetAttribute.endOffset());
            }

            tokenStream.end();

        } finally {
            tokenStream.close();
        }
    }


}
