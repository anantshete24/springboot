package com.example.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helper.Helper;
import com.example.model.Category;
import com.example.repo.CategoryRepo;

@Service
public class ExcelService {

	@Autowired
	private CategoryRepo repo;
	
	public ByteArrayInputStream getActualData() throws IOException
	{
		List<Category> all = repo.findAll();
		ByteArrayInputStream byteArrayInputStream=Helper.dataToExcel(all);
		return byteArrayInputStream;
	}
	
	
}
