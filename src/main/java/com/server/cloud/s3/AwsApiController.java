package com.server.cloud.s3;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.server.cloud.command.CusVO;

import software.amazon.awssdk.services.s3.model.PutObjectRequest;



@RestController
public class AwsApiController {

	
	@Value("${aws_access_key_id")
	private String aws_access_key_id;
	
	@Autowired
	S3Service s3;
	

	@Autowired
	AwsService awsService;
	
	@PostMapping("/api/main/cloudUpload")
	public ResponseEntity<?>upload(@RequestParam("file_data")MultipartFile file,@RequestParam("userId")String userId,
									@RequestParam("fileId")String fileId){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(1);
		try {
			String originName=file.getOriginalFilename();
			byte[]originData=file.getBytes();
			String objectURI =s3.putS3Object(originName,originData);
			FileVO fileVO=new FileVO().builder()
			.file_id(fileId)
			.file_name(originName)
			.file_path(objectURI)
			.file_type(file.getContentType())
			.upload_date(timestamp)
			.user_id(userId)
			.build();
			System.out.println(fileVO.toString());
			awsService.setInfo(fileVO);
			
			FileVO path=awsService.getImg(userId);
			return new ResponseEntity<>(path,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("?",HttpStatus.OK);
	}
//	@PostMapping("/api/main/cloudUpload2")
//	 public ResponseEntity<FileVO> addProduct(
//	            @RequestPart(value = "key") ProductRequestDto productRequestDto,
//	            @RequestPart(value = "multipartFile") List<MultipartFile> multipartFile,
//	            @AuthenticationPrincipal UserDetailsImpl userDetails){
//	        
//	        // AwsS3Service의 uploadFile 메소드를 호출하여 S3에 저장하고,
//	        // 그 반환값인 이미지파일 Dto 리스트를 ProductService의 addProduct 메소드의 매개변수로 전달하여
//	        // 유저가 작성한 내용과 함께 이미지 파일 DB에 저장
//	        return ResponseEntity.ok(productService.addProduct(productRequestDto,userDetails.getUser(), awsS3Service.uploadFile(multipartFile, dirName)));
//	    }
//
//	
	
	
	@PostMapping("/api/main/updateInfo")
	public ResponseEntity<?> updateInfo(@RequestBody CusVO vo){
		System.out.println(vo.toString());
		
		return new ResponseEntity<>("good",HttpStatus.OK);
	}
	@GetMapping("/api/main/getPoto")
	public ResponseEntity<?>getPoto(@RequestParam("cus_id")String cus_id){
		FileVO path=awsService.getImg(cus_id);
		System.out.println(path);
		return new ResponseEntity<>(path,HttpStatus.OK);
	}
	
	
}
