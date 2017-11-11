package com.javasampleapproach.s3.multipartfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.javasampleapproach.s3.multipartfile.services.S3Services;

@SpringBootApplication
public class SpringS3AmazonMultipartFileApplication implements CommandLineRunner{

	
	@Autowired
	S3Services s3Services;
	
	@Value("${jsa.s3.uploadfile}")
	private String uploadFilePath;
	
	@Value("${jsa.s3.downloadfile}")
	private String downloadFilePath;
	
	@Value("${jsa.s3.key}")
	private String key;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringS3AmazonMultipartFileApplication.class, args);
        System.exit(SpringApplication.exit(context));
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------------- START UPLOAD FILE ----------------");
		s3Services.uploadFile(key, uploadFilePath);
		System.out.println("---------------- START DOWNLOAD FILE ----------------");
		s3Services.downloadFile(key, downloadFilePath);
		System.out.println("DONE!");
	}
}
