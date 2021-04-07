package com.example.layuiweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.LongAdder;

@SpringBootTest
class LayuiWebApplicationTests {

	@Test
	void contextLoads() {
		LongAdder longAdder = new LongAdder();
		longAdder.add(10);
	}

}
