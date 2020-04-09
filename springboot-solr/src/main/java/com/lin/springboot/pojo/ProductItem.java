package com.lin.springboot.pojo;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductItem implements Serializable {

    @Field("id")/*使用这个注释，里面的名字是根据你在solr数据库中配置的来决定*/
    private Integer id;
    @Field("title")
    private String title;
    @Field("ingredients")
    private String ingredients;
    @Field("price")
    private Double price;
    @Field("num")
    private Integer num;
    @Field("image")
    private String image;
    @Field("cid")
    private Integer cid;
    @Field("status")
    private Integer status;
    @Field("create")
    private Date create;
    @Field("categoryName")
    private String categoryName;
}
