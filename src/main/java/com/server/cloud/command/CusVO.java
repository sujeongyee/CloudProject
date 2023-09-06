package com.server.cloud.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CusVO {
//	CUS_NUM binary(16) default (UUID_TO_BIN(UUID(),1)) primary key, 
//	CUS_ID VARCHAR(100),#아이디
//	CUS_COMPANY_NAME VARCHAR(1000),#회사 이름
//	CUS_POSTAL_CODE   INT,#우편 번호
//	CUS_ADDRESS1 VARCHAR(1000),#주소
//	CUS_ADDRESS2 VARCHAR(1000),#상세 주소
//	CUS_MANAGET_NAME VARCHAR(100),#담당자명 + 직급
//	CUS_PHONE_NUMBER INT, #담당자전화번호
//	CUS_EMAIL VARCHAR(1000),#담당자 이메일
//	CUS_BUSINESS_ID VARCHAR(1000),#사업자 등록번호
//	CUS_PW VARCHAR(1000),
//	ROLE_TYPE VARCHAR(100)
	
	
	private String cus_num;
	
	
	
	@NotNull(message="아이디는 필수입니다")
	@NotBlank(message = "공백일 수 없습니다!")
	@Pattern(message = "아이디는 영문자와 숫자로 구성되어야 하고 4자 이상이어야 됩니다.", regexp = "^[a-zA-Z0-9]{4,}$")
	private String cus_id;
	
	@NotEmpty(message="회사 이름은 필수입니다")
	@NotNull(message="회사 이름은 필수입니다")
	private String cus_company_name;
	
	@NotEmpty(message="우편번호를 입력하세요")
	@NotNull(message="우편번호를 입력하세요")
	@NotBlank(message = "공백일 수 없습니다!")
	private String cus_postal_code;
	@NotEmpty(message="주소를 입력하세요")
	@NotNull(message="주소를 입력하세요")
	private String cus_address1;
	@NotEmpty(message="상세주소를 입력하세요")
	@NotNull(message="상세주소를 입력하세요")
	private String cus_address2;
	@NotEmpty(message="이름을 입력하세요")
	@NotNull(message="이름을 입력하세요")
	private String cus_managet_name;
	@NotEmpty(message="휴대폰 번호를 입력하세요")
	@NotNull(message="휴대폰 번호를 입력하세요")
	@Pattern(message = "휴대폰 번호는 000-0000-0000으로 표기부탁드립니다", regexp = "^(\\d{2,3}-\\d{4}-\\d{4})$")
	private String cus_phone_number;
	@NotEmpty(message="이메일을 입력하세요")
	@NotBlank(message = "공백일 수 없습니다!")
	@Email(message="이메일 형식이어야 합니다!")
	private String cus_email;
	@NotEmpty(message="사업자 등록증을 입력하세요")
	@NotBlank(message = "사업자 등록증을 입력하세요")
	private String cus_business_id;
	@NotEmpty(message="비밀번호는 필수입니다")
	@NotNull(message="비밀번호는 필수입니다")
	@Pattern(message = "비밀번호는 최소 8자 이상이며 적어도 하나의 영문자, 특수문자,숫자를 포함해야 됩니다.", regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$")
	private String cus_pw;
	@NotEmpty(message="비밀번호는 필수입니다")
	@NotNull(message="비밀번호는 필수입니다")
	@Pattern(message = "비밀번호는 최소 8자 이상이며 적어도 하나의 영문자, 특수문자(예: !@#$%^&*()_+={}[]|:;\"'<>,.?/~),숫자를 포함해야 됩니다.", regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$")
	private String cus_pw_check;
	
	@NotEmpty(message="회사 번호를 입력하세요")
	@NotNull(message="회사 번호를 입력하세요")
	@Pattern(message = "회사 번호는 000(또는 00)-0000-0000으로 표기부탁드립니다", regexp = "^(\\d{2,3}-\\d{4}-\\d{4})$")
	private String cus_company_ph;
	
	@NotEmpty(message="대표자 성함을 입력하세요")
	private String cus_boss;
	private String role_type;
	
	
}
