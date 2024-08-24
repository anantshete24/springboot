package com.api.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	

	//file will upload here
	
	
	//public final String UPLOAD_DIR="C:\\Users\\Admin\\eclipse-workspace\\bootdevtool\\src\\main\\resources\\static\\image";
	
	
	final String UPLOAD_DIR=new ClassPathResource("C:\\Users\\Admin\\eclipse-workspace\\bootdevtool\\src\\main\\resources\\static\\dollara.png").getFile().getAbsolutePath();	
	public FileUploadHelper()throws IOException
	{
		

	}

	public boolean uploadfile(MultipartFile multipartFile)
	{
		boolean f1 = false;
		
		try
		{
			
	/*		//read - old way of read and write
			InputStream is=multipartFile.getInputStream();
			byte data[]=new byte[is.available()];
			is.read(data);
			
			//write
			FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
			fos.write(data);
			
			
		*/	
			f1=true;
			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f1;
	}
}
