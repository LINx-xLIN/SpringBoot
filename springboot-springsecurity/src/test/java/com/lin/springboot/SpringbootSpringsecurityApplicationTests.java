package com.lin.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringbootSpringsecurityApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	public void create() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String encode = encoder.encode("123456");
		System.out.println(encode);


	}

}
