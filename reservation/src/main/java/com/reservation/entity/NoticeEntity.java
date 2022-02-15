package com.reservation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.reservation.dto.NoticeDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(
        name="NOTICE_SEQ.NEXTVAL", //시퀀스 제너레이터 이름
        sequenceName="NOTICE_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )
@Table(name="notice")
public class NoticeEntity {

	@Id // primary key
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="NOTICE_SEQ.NEXTVAL" //식별자 생성기를 설정해놓은 시퀀스제너레이터로 설정        
            )
	private int no;
		

	private String title;
	private String contents;
	
	private String deleteFlg;
	
	@CreationTimestamp // insert시 현재 시간을 읽어서 저장
	private Date createdAt;
	
	@UpdateTimestamp // update시 현재 시간을 읽어서 저장
	private Date updatedAt;
	
	private int buildCd;
	
	private String lockFlg;
	
	private String passwd;
	
	@Builder
	public NoticeEntity(int no, String title, String contents, String deleteFlg, 
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