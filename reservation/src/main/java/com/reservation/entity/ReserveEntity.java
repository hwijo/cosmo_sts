package com.reservation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
        name="RESERVE_SEQ.NEXTVAL", //������ ���ʷ����� �̸�
        sequenceName="RESERVE_SEQ", //������ �̸�
        initialValue=1, //���۰�
        allocationSize=1 //�޸𸮸� ���� �Ҵ��� ���� ������
        )
@Table(name="reserve")
public class ReserveEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, //����� ������ ��������  ����
            generator="RESERVE_SEQ.NEXTVAL" //�ĺ��� �����⸦ �����س��� ���������ʷ����ͷ� ����            
            )
	private int no;		

	/*
	 * @ManyToOne(targetEntity=RoomInfoEntity.class, fetch=FetchType.LAZY) private
	 * int roomInfo_No; // room number, FK
	*/	
	private String name;
	private String phone;
	private String adult;
	private String child;
	private String startDate;
	private String endDate;
	private String options;
	private String paymentFlg; 
	private int totalcost;  
	private String cancelFlg;  
	private String bankName;  
	private String bankBranchCde;  
	private String bankNo;  
	private String deleteFlg;  

	
	@CreationTimestamp // insert�� ���� �ð��� �о ����
	private Date createdAt;
	
	@UpdateTimestamp // update�� ���� �ð��� �о ����
	private Date updatedAt;
	
	private int buildCd;
	
	private int roomNo;

	/*
	@ManyToOne(targetEntity=RoomInfoEntity.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "roomNum") // roomInfo의 기본키 no와 reserve의 외래키 roomNum 연결
	private RoomInfoEntity roomInfoEntity;
	*/
	
	private int roomNum;

	@Builder
	public ReserveEntity(int no, String name, String phone, String adult, String child, String startDate, String endDate, String options, 
			String paymentFlg, int totalcost, String cancelFlg, String bankName, String bankBranchCde, String bankNo,
			String deleteFlg, int buildCd, int roomInfo_No, RoomInfoEntity roomInfoEntity, int roomNum) {
	        
		    this.no = no;
	        this.name = name;
	        this.phone = phone;
	        this.adult = adult;
	        this.child = child;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.options = options;
	        this.paymentFlg = paymentFlg;
	        this.totalcost = totalcost;
	        this.cancelFlg = cancelFlg;
	        this.bankName = bankName;
	        this.bankBranchCde = bankBranchCde;
	        this.bankNo = bankNo;
	        this.deleteFlg = deleteFlg;
	        this.roomNum = roomNum;
	        //this.roomInfoEntity = roomInfoEntity;
	        this.buildCd = buildCd;     
	        
	    }



}
