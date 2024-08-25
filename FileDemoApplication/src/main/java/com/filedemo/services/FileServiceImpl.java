package com.filedemo.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		//file name
		String name=file.getOriginalFilename();
		String randomId=UUID.randomUUID().toString();
		String fileName1=randomId.concat(name.substring(name.lastIndexOf(".")));		
		
		//full path
		String filePath=path+File.separator+fileName1;

		//create folder if not created
			
		File f= new File(path);
		if(f.exists())
		{
			f.mkdir();
		}
		
		//file copy
		
		Files.copy(file.getInputStream(),Paths.get(filePath));
		
		return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) {
	
			String fullPath= path+File.separator+fileName;
			InputStream is = null;
			try {
				is = new FileInputStream(fullPath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return is;
	}
 
}
