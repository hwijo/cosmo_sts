package com.reservation.dto;



import java.util.Date;

import lombok.Data;



@Data
public class OptionsDto {
	
	private int no;		

	private String item;
	private String cost;
	private String Activity; // �ִ� �μ�
	private String deleteFlag;
	private Date createdAt;
	private Date updatedAt;
	private int buildCd;	
	


	

}
