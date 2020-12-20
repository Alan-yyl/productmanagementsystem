package com.alan.pms;

import com.alan.pms.controller.product.ProductBasicController;
import com.alan.pms.model.ProductBasicInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = {"com.alan.pms.service"})
class PmsWebApplicationTests {
	@Autowired
	ProductBasicController productBasicController;

	@Test
	void contextLoads() {

	}

	@Test
	void testFindData(){
		ProductBasicInformation information = new ProductBasicInformation();
		information.setId(1);
		// System.out.println(productBasicController.getAllProductBasic(1,10,information));

	}

}
