package com.server.cloud.command;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class S3Service {

	@Autowired
	private S3Client s3;
	
	
	@Value("${aws_bucket_name}")
	private String aws_bucket_name;
	
	//s3파일업로드
		public void putS3Object(String originName, byte[] originData) {
			
			try {
	            Map<String, String> metadata = new HashMap<>();
	            metadata.put("x-amz-meta-myVal", "test");
	            PutObjectRequest putOb = PutObjectRequest.builder()
	                .bucket(aws_bucket_name) // 버킷명
	                .key(originName) // 파일명
	                .metadata(metadata)
	                .build();
	            
	            //로컬에 있는 파일 읽어서 오브젝트에 올려준다는 코드
	            //s3.putObject(putOb, RequestBody.fromFile(new File(objectPath))); // 로컬파일 업로드시
	            PutObjectResponse response =  s3.putObject(putOb, RequestBody.fromBytes(originData)); 
	            System.out.println("Successfully placed " + originName +" into bucket "+ aws_bucket_name);

	            System.out.println("성공실패여부:" + response.sdkHttpResponse().statusCode());
	            
	        } catch (S3Exception e) {
	            System.err.println(e.getMessage());
	            //System.exit(1);
	        }
			
		}
}
