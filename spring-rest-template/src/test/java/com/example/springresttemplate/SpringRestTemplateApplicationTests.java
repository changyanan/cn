package com.example.springresttemplate;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class SpringRestTemplateApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		s:
		while (true){
			while (true){
				continue s;
			}
		}
	}
}
