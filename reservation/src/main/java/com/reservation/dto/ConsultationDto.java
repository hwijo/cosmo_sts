package com.reservation.dto;


import java.util.Date;

import com.reservation.entity.ConsultationEntity;
import com.reservation.entity.ConsultationEntity.ConsultationEntityBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
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
	

	@Builder
	public ConsultationDto(int no, String name, int grno, int grgrod, int depth, String title, String contents, String passwd, String lockFlg, String deleteFlg,
			Date createdAt,  Date updatedAt, int buildCd) {
	        this.no = no;	       
		    this.name = name;
	        this.grno = grno;
	        this.grgrod = grgrod;
	        this.depth = depth;
	        this.title = title;
	        this.contents = contents;
	        this.passwd = passwd;
	        this.lockFlg = lockFlg;
	        this.deleteFlg = deleteFlg;
	        this.createdAt = createdAt;
	        this.updatedAt = updatedAt;
 
	        
	    }



	
	

	
	

}
