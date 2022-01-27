package com.reservation.dto;



import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
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
	
	@Builder
	public RoomInfoDto(int no, String roomNum, String roomTitle, int max, int adultCost,
			int childCost, String explnation, String images, String colorCd,
			String deleteFlg, Date createdAt, Date updatedAt, int buildCd) {
		this.no = no;
		this.roomNum = roomNum;
		this.roomTitle = roomTitle;
		this.max = max;
		this.adultCost = adultCost;
		this.childCost = childCost;
		this.explnation = explnation;
		this.images = images;
		this.colorCd = colorCd;
		this.deleteFlg = deleteFlg;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.buildCd = buildCd;
	}
	
	

	

}
