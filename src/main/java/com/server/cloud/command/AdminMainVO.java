package com.server.cloud.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminMainVO {

	    
	   private int TOTAL_CUS_ID_COUNT;
	   private int TOTAL_PRO_NAME_COUNT;
	   private int TOTAL_ENG_ENID_COUNT;
	   private int PRO_STATUS_WAITING_COUNT;
	   
	   
	   private int contracts;
	   private int expiration;
	   
	   private int periodic;
	   private int emergency;
	   private int approval;
	   private int complete;
	   
	
	   
}
