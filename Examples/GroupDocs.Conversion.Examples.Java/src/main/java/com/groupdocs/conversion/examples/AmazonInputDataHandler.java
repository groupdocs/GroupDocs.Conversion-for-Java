package com.groupdocs.conversion.examples;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.groupdocs.conversion.domain.FileDescription;
import com.groupdocs.conversion.handler.input.IInputDataHandler;

public class AmazonInputDataHandler implements IInputDataHandler {
	 
    private static String bucketName = ""; //TODO: Put you bucketname here 
    private AmazonS3Client _client;
 
    public AmazonInputDataHandler(String accessKey, String secretKey) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        _client = new AmazonS3Client(credentials);
    }
 
    @Override
    public FileDescription getFileDescription(String guid) {
        FileDescription result = new FileDescription();
        GetObjectRequest request = new GetObjectRequest(bucketName, guid);
        String fileName;
        long size;
        S3Object response = _client.getObject(request);
        fileName = response.getKey();
        size = response.getObjectMetadata().getContentLength();
        result.setGuid(guid);
        result.setName(fileName);
        result.setSize(size);
        return result;
    }

	public com.groupdocs.conversion.internal.c.a.ms.System.IO.Stream lO(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.groupdocs.conversion.internal.c.a.ms.System.IO.Stream hM(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
 
    
}