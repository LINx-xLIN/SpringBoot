package com.lin.springboot.mapper;

import com.lin.springboot.pojo.City;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CityMapper extends Repository<City,Integer> {
    List<City> findAll();
}
