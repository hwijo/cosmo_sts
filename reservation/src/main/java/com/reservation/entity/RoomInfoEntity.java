package com.reservation.entity;


import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name="ROOMINFO_SEQ.NEXTVAL", //������ ���ʷ����� �̸�
        sequenceName="ROOMINFO_SEQ", //������ �̸�
        initialValue=1, //���۰�
        allocationSize=1 //�޸𸮸� ���� �Ҵ��� ���� ������
        )
@Table(name="roomInfo")
public class RoomInfoEntity {

	@Id
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //����� ������ ��������  ����
            generator="ROOMINFO_SEQ.NEXTVAL" //�ĺ��� �����⸦ �����س��� ���������ʷ����ͷ� ����            
            )
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
	
	@CreationTimestamp // insert�� ���� �ð��� �о ����
	private Date createdAt;
	
	@UpdateTimestamp // update�� ���� �ð��� �о ����
	private Date updatedAt;
	private int buildCd;
	

	@Builder
	public RoomInfoEntity(int no, String roomNum, int max, int adultCost, int childCost, String explanation, String images, String deleteFlg, int buildCd) {
	        
		    this.no = no;
	        this.roomNum = roomNum;
	        this.max = max;
	        this.adultCost = adultCost;
	        this.childCost = childCost;
	        this.explnation = explanation;
	        this.images = images;
	        this.deleteFlg = deleteFlg;
	        this.buildCd = buildCd;

	        
	    }
	
	
	
	

}
