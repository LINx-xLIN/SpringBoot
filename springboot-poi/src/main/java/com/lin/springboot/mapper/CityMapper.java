package com.lin.springboot.mapper;

import com.lin.springboot.pojo.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CityMapper {

    @Select("select * from city")
   List<City> selectAll();
}
