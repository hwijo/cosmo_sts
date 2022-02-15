package com.reservation.dto;


import java.util.Date;



import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class NoticeDto {
	private int no;		
	private String title;
	private String contents;	
	private String deleteFlg;
	private Date createdAt;	
	private Date updatedAt;	
	private int buildCd;
	private String lockFlg;
	private String passwd;
	
	
	@Builder
	public NoticeDto(int no, String title, String contents, String deleteFlg, 
			Date createdAt, Date updatedAt, int buildCd, String lockFlg, String passwd) {
	        
		    this.no = no;
	        this.title = title;
	        this.contents = contents;
	        this.deleteFlg = deleteFlg;
	        this.createdAt = createdAt;
	        this.updatedAt = updatedAt;
	        this.buildCd = buildCd;
	        this.lockFlg = lockFlg;
	        this.passwd = passwd;     
 
	        
	    }
	
}
