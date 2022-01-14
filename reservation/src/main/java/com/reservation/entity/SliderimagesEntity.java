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
        name="SLIDERIMAGES_SEQ.NEXTVAL", //������ ���ʷ����� �̸�
        sequenceName="SLIDERIMAGES_SEQ", //������ �̸�
        initialValue=1, //���۰�
        allocationSize=1 //�޸𸮸� ���� �Ҵ��� ���� ������
        )
@Table(name="sliderimages")
public class SliderimagesEntity {
	
	@Id
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //����� ������ ��������  ����
            generator="SLIDERIMAGES_SEQ.NEXTVAL" //�ĺ��� �����⸦ �����س��� ���������ʷ����ͷ� ����            
            )
	private int no;		



	private String filename;
	private String sortNo;
	private String Activity; // �ִ� �μ�
	private String deleteFlg;
	
	@CreationTimestamp // insert�� ���� �ð��� �о ����
	private Date createdAt;
	
	@UpdateTimestamp // update�� ���� �ð��� �о ����
	private Date updatedAt;
	
	
	

}
