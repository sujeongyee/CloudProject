package com.server.cloud.main.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.server.cloud.command.CusVO;
import com.server.cloud.main.service.UserService;

@RestController
public class MainController {
	
	@Autowired
	private UserService userService;

	
	
	@PostMapping("/main/sing-up")
	public ResponseEntity<Map<String, String> > singUp(@Valid @RequestBody CusVO vo,BindingResult bindingResult) {
		
		String result = userService.idCheck(vo.getCus_id());
		
		if(result==null) {
			
		Map<String, String> errM=new HashMap<>();

		if(bindingResult.hasErrors()) {
			List<FieldError>list=bindingResult.getFieldErrors();
			for(FieldError err:list) {

				System.out.println(err.getField());
				errM.put(err.getField(), err.getDefaultMessage());
			}



			System.out.println(errM.toString());
			return new ResponseEntity<>(errM,HttpStatus.OK);
		}
		
				userService.singIn(vo);
			
		
		return new ResponseEntity<>(errM,HttpStatus.OK);
		}
		return null;
	}


	@PostMapping("/main/pw_check")
	public ResponseEntity<Map<String, String> > pw_check(@RequestBody Map<String,Object>ch) {

		Map<String, String> errM=new HashMap<>();

		if(ch.get("cus_pw").equals(ch.get("cus_pw_check"))) {
			errM.put("pw_check","");
			return new ResponseEntity<>(errM,HttpStatus.OK);
		}
		errM.put("pw_check","비밀번호가 일치하지 않습니다");
		return new ResponseEntity<>(errM,HttpStatus.OK);
	}

	@PostMapping("/main/idCheck")
	public ResponseEntity<Map<String, String> > idCheck(@RequestBody Map<String,Object> userId) {
		System.out.println(userId);
		Map<String, String> response = new HashMap<>();

		if (((String)userId.get("cus_id")).isEmpty()) {
			response.put("error", "userId는 비어있을 수 없습니다.");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}

		// 여기서 userId를 사용하여 추가적인 유효성 검사를 수행합니다.
		if (!isValidUserId(((String)userId.get("cus_id")))) {
			response.put("error", "아이디는 영문자와 숫자로 구성되어야 하고 4자 이상이어야 합니다.");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}

		String result = userService.idCheck(((String)userId.get("cus_id")));

		if(result==null) {
			response.put("message", "아이디 사용 가능");
			return new ResponseEntity<>(response,HttpStatus.OK);
			
		}else {
			response.put("error", "아이디가 중복입니다");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		// 성공적인 응답
	}

	private boolean isValidUserId(String userId) {

		return userId.matches("^(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]{4,}$");
	}


	@PostMapping("/main/businessCheck")
	public ResponseEntity<Map<String, String>> validateBusinessRegistrationNumber(@RequestBody Map<String,Object> registrationNumber) {
		System.out.println(registrationNumber);
		Map<String, String> response = new HashMap<>();
		String cleanedRegistrationNumber = ((String)registrationNumber.get("cus_business_id")).replaceAll("-", "");
		if (isValidBusinessRegistrationNumber(cleanedRegistrationNumber)) {
			response.put("message", "인증 완료");
			System.out.println(response.toString());
			return new ResponseEntity<>(response,HttpStatus.OK);
		}else {

			System.out.println(cleanedRegistrationNumber);
			response.put("error", "유요하지 않은 사업자 번호입니다");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}




	}
	private final static int[] LOGIC_NUM = {1, 3, 7, 1, 3, 7, 1, 3, 5, 1};
	public boolean isValidBusinessRegistrationNumber(String number) {
		if (!isNumeric(number) || number.length() != 10)
			return false;

		int sum = 0;
		int j = -1;
		for (int i = 0; i < 9; i++) {
			j = Character.getNumericValue(number.charAt(i));
			sum += j * LOGIC_NUM[i];
		}

		sum += (int) (Character.getNumericValue(number.charAt(8)) * 5 /10);

		int checkNum = (10 - sum % 10) % 10 ;
		return (checkNum == Character.getNumericValue(number.charAt(9)));
	}

	public boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
}

