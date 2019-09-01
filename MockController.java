package com.mock.product.mockproductstub.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/catalog/mock")
public class MockController {
	
	private static final Logger logger = LoggerFactory.getLogger(MockController.class);
	ObjectMapper mapper = new ObjectMapper();
	File productFile;	
	File upcFile;
	
	@GetMapping(path ="/products")
	public Map<String, Object> getProductData() throws JsonGenerationException, JsonMappingException, IOException {
		productFile =  ResourceUtils.getFile("classpath:products.json");				
		Map<String, Object> products = (Map<String, Object>) mapper.readValue(productFile, Object.class);
		logger.info("Returning all the products::::::::::::::{} " + products);
		return products;	
	}
	
	@GetMapping("/products/{id}")
	public Map<String, Object> getProductByID(@PathVariable String id) throws JsonGenerationException, JsonMappingException, IOException {
		productFile =  ResourceUtils.getFile("classpath:products.json");	
		
		String[] strings = id.split(",");
		int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
		
		//logger.info("array of elements" +array.length);
		Map<String, Object> products = (Map<String, Object>) mapper.readValue(productFile, Object.class);
	
		Map<String , Object> prod =(Map<String, Object>) products.get("products");		
		//logger.info("All Products:::::::::{}" + prod);

		List<Map<String, Object>> list = (List<Map<String, Object>>) prod.get("product"); 
		//logger.info("list of product:::::::::{}" + list);
		

		List<Map<String, Object>> collect = list.stream().filter((Map<String,Object> s) -> {
			return Arrays.stream(array).anyMatch(n -> n == (int)s.get("id"));
					}).collect(Collectors.toList());
		
		if(collect.size()>0) {
			logger.info("collector " + collect);		
			prod.put("product", collect);
			return products;
		}
		else {
			throw new RuntimeException("Product Details not found with ID Specified !!! Specify the Correct Product ID");
		}
	}

}
