package com.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import com.api.entity.Product;
import com.api.helper.Helper;
import com.api.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	
	
	public void save(MultipartFile file) throws IOException
	{
	
		List<Product> products=Helper.convertExcelToListOfProducts(file.getInputStream());
		this.productRepo.saveAll(products);
	}
	
	public List<Product> getAllProducts()
	{
		
		return this.productRepo.findAll();
	
	}
	
	
}
