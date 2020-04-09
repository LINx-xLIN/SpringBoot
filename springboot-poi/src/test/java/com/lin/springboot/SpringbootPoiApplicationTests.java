package com.lin.springboot;

import com.lin.springboot.mapper.CityMapper;
import com.lin.springboot.pojo.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@SpringBootTest
class SpringbootPoiApplicationTests {

	@Autowired
	private CityMapper cityMapper;


	@Test
	void contextLoads() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		//System.out.println(cityMapper.selectAll());

		City city = cityMapper.selectAll().get(0);
		Class<?> c = Class.forName("com.lin.springboot.pojo.City");
		Field[] fields = c.getDeclaredFields();

		Method method = null;
		for (Field field : fields) {
			System.out.println(Modifier.toString(field.getModifiers()));//private
			System.out.println(field.getType().getSimpleName());//Integer
			System.out.println(field.getName().substring(0,1).toUpperCase()+field.getName().substring(1));//id

			//method = c.getDeclaredMethod("get"+)


		}

		Method getName = c.getDeclaredMethod("getName");

		System.out.println(getName.invoke(city));


	}

}
