package com.alan.pms;

import com.alan.pms.controller.product.ProductBasicController;
import com.alan.pms.mapper.product.ProductBasicMapper;
import com.alan.pms.model.ProductBasicInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import com.alan.pms.utils.NlpUtils;

@SpringBootTest
@ComponentScan(basePackages = {"com.alan.pms.service"})
class PmsWebApplicationTests {
	@Autowired
	ProductBasicController productBasicController;
	@Autowired
	ProductBasicMapper productBasicMapper;

	@Test
	void contextLoads() {

	}

	@Test
	void testFindData(){
		List<ProductBasicInformation> list=productBasicMapper.findAll(0,5000,null,null,null);
		for (ProductBasicInformation product:list
			 ) {
			product.setProductName(NlpUtils.detectContent(product.getProductName()));
			productBasicMapper.insertOrUpdate(product);
		}
	}

}
