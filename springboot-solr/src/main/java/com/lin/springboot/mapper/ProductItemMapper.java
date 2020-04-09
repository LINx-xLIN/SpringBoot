package com.lin.springboot.mapper;

import com.lin.springboot.pojo.ProductItem;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductItemMapper {

    @Select("SELECT a.*,b.name categoryName FROM pms_product_item a LEFT JOIN pms_product_category b ON a.cid = b.id")
    List<ProductItem> selectAll();

}
