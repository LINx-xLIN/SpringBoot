package com.lin.springboot;

import com.lin.springboot.mapper.ProductItemMapper;
import com.lin.springboot.pojo.ProductItem;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class SpringbootSolrApplicationTests {

    @Autowired
    private SolrClient solrClient;

    @Autowired
    private ProductItemMapper productItemMapper;


    @Test

    void createDataIndex() {
        //System.out.println(productItemMapper.selectAll().get(0));

        try {

            List<ProductItem> productItems = productItemMapper.selectAll();
            //单个增加
            //solrClient.addBean(productItems.get(0));

            //批量增加
            solrClient.addBeans(productItems);

            solrClient.commit();


        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    void deleteAll() {
        try {
            solrClient.deleteByQuery("*:*");
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void deleteById() {
        try {
            solrClient.deleteById("1");
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    void select() throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();

        solrQuery.set("q", "*虾*");
        QueryResponse query = solrClient.query(solrQuery);

        SolrDocumentList results = query.getResults();

        for (SolrDocument document : results) {
            System.out.println(document.get("title"));
        }
    }






}
