package com.reservation.entity;


import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@SequenceGenerator(
        name="CONSULTATION_SEQ.NEXTVAL", //������ ���ʷ����� �̸�
        sequenceName="CONSULTATION_SEQ", //������ �̸�
        initialValue=1, //���۰�
        allocationSize=1 //�޸𸮸� ���� �Ҵ��� ���� ������
        )
@Table(name="consultation")
public class ConsultationEntity {

	@Id // primary key
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //����� ������ ��������  ����
            generator="CONSULTATION_SEQ.NEXTVAL" //�ĺ��� �����⸦ �����س��� ���������ʷ����ͷ� ����        
            )
	private int no;
		
	private String name;
	private int grno; // 댓글 번호
	private int grgrod; // 답글 번호 (그냥 댓글 : 0)
	private int depth; // 깊이 (그냥 댓글 : 0, 답글 : 1, 다음 답글 : 2...)
	private String title;
	private String contents;
	private String passwd;
	private String lockFlg;
	private String deleteFlg;
	
	
	@CreationTimestamp // insert시 현재 시간을 읽어서 저장
	private Date createdAt;
	
	@UpdateTimestamp // update시 현재 시간을 읽어서 저장
	private Date updatedAt;
	
	//private int buildCd;
	
	
	
	@Builder
	public ConsultationEntity(String name, int grno, int grgrod, int depth, String title, String contents, String passwd) {
	        
		    this.name = name;
	        this.grno = grno;
	        this.grgrod = grgrod;
	        this.depth = depth;
	        this.title = title;
	        this.contents = contents;
	        this.passwd = passwd;
 
	        
	    }
	


}
