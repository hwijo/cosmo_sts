package com.reservation.dto;



import java.util.Date;

import lombok.Data;


@Data
public class RoomInfoDto {
	
	private int no;		

	private String roomNum;
	private String roomTitle;
	private int max; // �ִ� �μ�
	private int adultCost;
	private int childCost;
	private String explnation; // ����
	private String images;  
	private String colorCd;  
	private String deleteFlg;  	
	private Date createdAt;	
	private Date updatedAt;
	private int buildCd;
	
	

	

}
