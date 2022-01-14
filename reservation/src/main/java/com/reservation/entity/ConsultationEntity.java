package com.reservation.entity;


import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
@SequenceGenerator(
        name="CONSULTATION_SEQ.NEXTVAL", //������ ���ʷ����� �̸�
        sequenceName="CONSULTATION_SEQ", //������ �̸�
        initialValue=1, //���۰�
        allocationSize=1 //�޸𸮸� ���� �Ҵ��� ���� ������
        )
@Table(name="notice")
public class ConsultationEntity {

	@Id // primary key
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //����� ������ ��������  ����
            generator="CONSULTATION_SEQ.NEXTVAL" //�ĺ��� �����⸦ �����س��� ���������ʷ����ͷ� ����        
            )
	private int no;
		
	private int grno;
	private int grgrod;
	private int depth;
	private String title;
	private String contents;
	private String passwd;
	private String lockFlg;
	private String deleteFlg;
	private Date createdAt;
	private Date updatedAt;
	private int buildCd;
	


}
