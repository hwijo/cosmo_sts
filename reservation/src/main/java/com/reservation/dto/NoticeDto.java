package com.reservation.dto;


import java.util.Date;

import lombok.Data;


@Data
public class NoticeDto {
	private int no;		
	private String title;
	private String contents;	
	private String deleteFlg;
	private Date createdAt;	
	private Date updatedAt;	
	private int buildCd;	

	
	

}
