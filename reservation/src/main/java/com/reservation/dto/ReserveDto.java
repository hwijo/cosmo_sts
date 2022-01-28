package com.reservation.dto;


import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.reservation.entity.RoomInfoEntity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
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

	/*
	@ManyToOne(targetEntity=RoomInfoEntity.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "roomNum") // roomInfo의 기본키 no와 reserve의 외래키 roomNum 연결
	private RoomInfoEntity roomInfoEntity;
	*/
	
	@Builder
	public ReserveDto(String name, String phone, String adult, String child, String startDate, String endDate, String options, 
			String paymentFlg, int totalcost, String cancelFlg, String bankName, String bankBranchCde, String bankNo,
			String deleteFlg, int buildCd, int roomInfo_No, RoomInfoEntity roomInfoEntity, int roomNum) {
	        
	        this.name = name;
	        this.phone = phone;
	        this.adult = adult;
	        this.child = child;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.options = options;
	        this.paymentFlg = paymentFlg;
	        this.totalcost = totalcost;
	        this.cancelFlg = cancelFlg;
	        this.bankName = bankName;
	        this.bankBranchCde = bankBranchCde;
	        this.bankNo = bankNo;
	        this.deleteFlg = deleteFlg;
	        this.roomNum = roomNum;
	        //this.roomInfoEntity = roomInfoEntity;
	        this.buildCd = buildCd;     
	        
	    }
	
	

	

}
