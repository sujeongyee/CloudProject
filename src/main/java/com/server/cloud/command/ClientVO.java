package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientVO {

//회사명 - CUS_COMPANY_NAME 
//대표명 CUS_BOSS
//사업자등록번호CUS_BUSINESS_ID
//회사연락처CUS_COMPANY_PH
//회사주소CUS_ADDRESS1 CUS_ADDRESS2
//담당자이름CUS_MANAGET_NAME
//담당자이메일CUS_EMAIL 
//담당자연락처CUS_PHONE_NUMBER
//   PRO_STARTDATE   VARCHAR(100), #시작일
//   PRO_ENDDATE   VARCHAR(100), #만료일
//계약상태PRO_STATUS
	
	private String cus_company_name;
	private String cus_boss;
	private String cus_business_id;
	private String cus_company_ph;
	private String cus_address1;
	private String cus_address2;
	private String cus_email;
	private String cus_phone_number;
	private String pro_startdate;
	private String pro_enddate;
	private String pro_status;
	
}
