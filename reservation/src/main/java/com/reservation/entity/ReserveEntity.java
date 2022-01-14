package com.reservation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;


@Entity
@Data
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

	
	private int roomInfo_No; // room number, FK
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
	private Date createdAt;
	private Date updatedAt;
	private int buildCd;
	
	public int getNo() {
		return no;
	}
	public int getRoomInfo_No() {
		return roomInfo_No;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAdult() {
		return adult;
	}
	public String getChild() {
		return child;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public String getOptions() {
		return options;
	}
	public String getPaymentFlg() {
		return paymentFlg;
	}
	public int getTotalcost() {
		return totalcost;
	}
	public String getCancelFlg() {
		return cancelFlg;
	}
	public String getBankName() {
		return bankName;
	}
	public String getBankBranchCde() {
		return bankBranchCde;
	}
	public String getBankNo() {
		return bankNo;
	}
	public String getDeleteFlg() {
		return deleteFlg;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public int getBuildCd() {
		return buildCd;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	public void setRoomInfo_No(int roomInfo_No) {
		this.roomInfo_No = roomInfo_No;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public void setPaymentFlg(String paymentFlg) {
		this.paymentFlg = paymentFlg;
	}
	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}
	public void setCancelFlg(String cancelFlg) {
		this.cancelFlg = cancelFlg;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setBankBranchCde(String bankBranchCde) {
		this.bankBranchCde = bankBranchCde;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setBuildCd(int buildCd) {
		this.buildCd = buildCd;
	}
	

}
