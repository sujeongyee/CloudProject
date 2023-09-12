package com.server.cloud.s3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.regions.Region;
@Component
public class S3Service {

	
	@Value("${aws_access_key_id}")
	private String aws_access_key_id;

	@Value("${aws_secret_access_key}")
	private String aws_secret_access_key;

	@Value("${aws_bucket_name}")
	private String bucketName;


	@Autowired
	S3Client s3;
	
	public void getBuketList() {
		
		ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
		ListBucketsResponse listBucketsResponse = s3.listBuckets(listBucketsRequest);
		listBucketsResponse.buckets().stream().forEach(x -> System.out.println(x.name()));

		
	}
	
	public String putS3Object(String originName, byte[] originData) {
		// TODO Auto-generated method stub
		
		try {
			Map<String, String>metaData=new HashMap<>();
			metaData.put("x-amz-meta-myVal", "test");
			PutObjectRequest putOb=PutObjectRequest.builder()
					.bucket(bucketName)
					.key(originName)
					.metadata(metaData)
					.build();
			
			PutObjectResponse response=s3.putObject(putOb, RequestBody.fromBytes(originData));
			 String objectURI = "https://" + bucketName + ".s3.amazonaws.com/" + originName;
			 return objectURI;
		}catch (Exception e) {
			   e.printStackTrace();
		        return null;
		}
		
		
	}
	
	
}
