package com.reservation.dto;


import java.util.Date;

import com.reservation.entity.RoomInfoEntity;

import lombok.Data;



@Data
public class ReserveDto {	
	private int no;		

	private int roomInfo_No; // room number, FK
	private String name;
	private String phone;
	private String adult;
	private String child;
	private String startDate;
	private String endDate;
	private String options;
	private String paymentFlg; 
	private int totalcost;  
	private String cancelFlg;  
	private String bankName;  
	private String bankBranchCde;  
	private String bankNo;  
	private String deleteFlg;  
	private Date createdAt;
	private Date updatedAt;
	private int buildCd;
	
	private int roomNo;
	private int roomNum;
	
	private RoomInfoEntity roomInfoEntity;
	
	

	

}
