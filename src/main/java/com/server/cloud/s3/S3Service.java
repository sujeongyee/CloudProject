package com.server.cloud.s3;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Delete;
import software.amazon.awssdk.services.s3.model.DeleteObjectsRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectsResponse;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.ObjectIdentifier;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.regions.Region;
@Slf4j
@Component
@RequiredArgsConstructor
public class S3Service {

	
	@Value("${aws_access_key_id}")
	private String aws_access_key_id;

	@Value("${aws_secret_access_key}")
	private String aws_secret_access_key;

	@Value("${aws_bucket_name}")
	private String bucketName;


	@Autowired
	S3Client s3;
	
//	private final AmazonS3 amazons3;
	
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
	
//	public List<FileVO> uploadFile(List<MultipartFile> multipartFile, String dirName) {
//        List<FileVO> fileVO = new ArrayList<>();
// 
//        // forEach 구문을 통해 multipartFile로 넘어온 파일들 하나씩 reponseDto에 추가
//        multipartFile.forEach(file -> {
//            String fileName = createFileName(file.getOriginalFilename(), dirName);
//            ObjectMetadata objectMetadata = new ObjectMetadata();
//            objectMetadata.setContentLength(file.getSize());
//            objectMetadata.setContentType(file.getContentType());
// 
//            try(InputStream inputStream = file.getInputStream()) {
//                amazons3.putObject(new com.amazonaws.services.s3.model.PutObjectRequest(bucketName, fileName, inputStream, objectMetadata)
//                        .withCannedAcl(CannedAccessControlList.PublicRead));
//                log.info("a3 업로드 성공");
//            } catch(IOException e) {
//                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
//            }
// 
//            // file에 관한 내용을 Vo로 변환 후 list에 담아 return
//            fileVO.add(new FileVO(file.getOriginalFilename(), fileName, file.getSize()));
// 
// 
// 
//        });
// 
//        return fileVO;
//    }
//	
//	public void deleteFile(String fileName, String dirName) {
//        amazons3.deleteObject(new DeleteObjectRequest(bucketName, dirName + "/" + fileName));
//    }
// 
//    // 먼저 파일 업로드 시, 파일명을 난수화하기 위해 UUID를 붙여준다.
//    private String createFileName(String fileName, String dirName) {
//        return dirName + "/" + UUID.randomUUID().toString().concat(getFileExtension(fileName));
//    }
// 
//    // file 형식이 잘못된 경우를 확인하기 위해 만들어진 로직이며, 파일 타입과 상관없이 업로드할 수 있게 하기 위해 .의 존재 유무만 판단하였다.
//    private String getFileExtension(String fileName) {
//        try {
//            return fileName.substring(fileName.lastIndexOf("."));
//        } catch (StringIndexOutOfBoundsException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 형식의 파일(" + fileName + ") 입니다.");
//        }
//    }

	public void deleteBucketObjects(String name) {

		// Upload three sample objects to the specfied Amazon S3 bucket.
		ArrayList<ObjectIdentifier> keys = new ArrayList<>();

		System.out.println("==================>" + bucketName);
		System.out.println("==================>" + name);
		//삭제할 객체
		ObjectIdentifier objectId= ObjectIdentifier.builder()
				.key(name)
				.build();

		keys.add(objectId);

		// Delete multiple objects in one request.
		Delete del = Delete.builder()
				.objects(keys)
				.build();

		try {
			DeleteObjectsRequest multiObjectDeleteRequest = DeleteObjectsRequest.builder()
					.bucket(bucketName)
					.delete(del)
					.build();
			
			DeleteObjectsResponse result= s3.deleteObjects(multiObjectDeleteRequest);
			System.out.println("Multiple objects are deleted!");
			System.out.println(result.sdkHttpResponse().statusCode());
		} catch (S3Exception e) {
			System.err.println(e.awsErrorDetails().errorMessage());
			// System.exit(1);
		}
	}
	
}
