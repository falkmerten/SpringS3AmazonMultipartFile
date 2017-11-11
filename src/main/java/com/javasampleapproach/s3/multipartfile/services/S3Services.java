package com.javasampleapproach.s3.multipartfile.services;

public interface S3Services {
	public void uploadFile(String keyName, String uploadFilePath);
	public void downloadFile(String keyName, String downloadFilePath);
}
