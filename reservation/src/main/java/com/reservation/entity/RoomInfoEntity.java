package com.reservation.entity;


import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.Getter;


@Entity
@Data
@SequenceGenerator(
        name="ROOMINFO_SEQ.NEXTVAL", //������ ���ʷ����� �̸�
        sequenceName="ROOMINFO_SEQ", //������ �̸�
        initialValue=1, //���۰�
        allocationSize=1 //�޸𸮸� ���� �Ҵ��� ���� ������
        )
@Table(name="roominfo")
public class RoomInfoEntity {

	@Id
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //����� ������ ��������  ����
            generator="ROOMINFO_SEQ.NEXTVAL" //�ĺ��� �����⸦ �����س��� ���������ʷ����ͷ� ����            
            )
	private int no;		


	private String roomNum;
	
	private String roomTitle;
	private int maxpeople; // �ִ� �μ�
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
	

	
	
	
	
	

}
