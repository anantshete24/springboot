package com.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.book.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	
				@Autowired
				private FileUploadHelper fileUploadHelper;

	
/*	
    FileUploadController(FileUploadHelper fileUploadHelper) {
        this.fileUploadHelper = fileUploadHelper;
    }
	
	
*/
	@PostMapping("/upload-file")
	public ResponseEntity <String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		try {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.isEmpty());
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
		}
		if(!file.getContentType().equals("image/jpeg"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG contect type are allowed");
		}
		
		//Now file upload code
		boolean f=fileUploadHelper.uploadfile(file);
		if(f)
		{
			return ResponseEntity.ok("file is sucessfully uploaded");
		//	return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename().toUriString()));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}
}
