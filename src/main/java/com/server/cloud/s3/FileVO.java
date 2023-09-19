package com.server.cloud.s3;

import java.sql.Timestamp;
import java.util.List;

import com.server.cloud.command.CusVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileVO {

	private String file_id;
	private String file_name;
	private String file_path;
	private String file_type;
	private Timestamp upload_date ;
	private String user_id;
	private String user_num;
	private String eng_enid;
	
	
}
