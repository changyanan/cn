package cn.itook.demo.springboot;

import cn.itook.demo.springboot.model.UserExcelModel;
import cn.itook.demo.springboot.utils.ValidationUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class DemoSpringbootApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void testValidation(){
		UserExcelModel userExcelModel = new UserExcelModel();
		userExcelModel.setName("fsdfsdf");
		userExcelModel.setAge(10);
		userExcelModel.setMobile("12348763463");
		userExcelModel.setSex("男");
		try {
			ValidationUtils.validate(userExcelModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
