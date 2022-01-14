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
	
	public int getNo() {
		return no;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public String getRoomTitle() {
		return roomTitle;
	}
	public int getMax() {
		return max;
	}
	public int getAdultCost() {
		return adultCost;
	}
	public int getChildCost() {
		return childCost;
	}
	public String getExplnation() {
		return explnation;
	}
	public String getImages() {
		return images;
	}
	public String getColorCd() {
		return colorCd;
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
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public void setAdultCost(int adultCost) {
		this.adultCost = adultCost;
	}
	public void setChildCost(int childCost) {
		this.childCost = childCost;
	}
	public void setExplnation(String explnation) {
		this.explnation = explnation;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public void setColorCd(String colorCd) {
		this.colorCd = colorCd;
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
