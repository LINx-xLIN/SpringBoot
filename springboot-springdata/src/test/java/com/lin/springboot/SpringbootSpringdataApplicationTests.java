package com.lin.springboot;

import com.lin.springboot.mapper.CityMapper;
import com.lin.springboot.pojo.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootSpringdataApplicationTests {

	@Autowired
	private CityMapper cityMapper;


	@Test
	void findAll() {

		List<City> cities = cityMapper.findAll();
		System.out.println(cities);
	}

}
