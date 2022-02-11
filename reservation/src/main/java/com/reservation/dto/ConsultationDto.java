package com.reservation.dto;


import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class ConsultationDto {	
	
	private int no;
		
	private int grno;
	private int grgrod;
	private int depth;
	private String title;
	private String contents;
	private String name;
	private String passwd;
	private String lockFlg;
	private String deleteFlg;
	private Date createdAt;
	private Date updatedAt;
	private int buildCd;
	

	
	

}
