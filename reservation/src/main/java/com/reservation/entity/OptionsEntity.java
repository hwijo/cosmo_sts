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
        name="OPTIONS_SEQ.NEXTVAL", //������ ���ʷ����� �̸�
        sequenceName="OPTIONS_SEQ", //������ �̸�
        initialValue=1, //���۰�
        allocationSize=1 //�޸𸮸� ���� �Ҵ��� ���� ������
        )
@Table(name="options")
public class OptionsEntity {
	
	@Id
	@GeneratedValue(
            strategy=GenerationType.SEQUENCE, //����� ������ ��������  ����
            generator="OPTIONS_SEQ.NEXTVAL" //�ĺ��� �����⸦ �����س��� ���������ʷ����ͷ� ����            
            )

	
	@CreationTimestamp // insert�� ���� �ð��� �о ����
	private Date createdAt;
	
	@UpdateTimestamp // update�� ���� �ð��� �о ����
	private Date updatedAt;
	private int buildCd;	
	
	public int getNo() {
		return no;
	}
	public String getItem() {
		return item;
	}
	public String getCost() {
		return cost;
	}
	public String getActivity() {
		return Activity;
	}
	public String getDeleteFlag() {
		return deleteFlag;
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
	
	
	private int no;		

	public void setNo(int no) {
		this.no = no;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public void setActivity(String activity) {
		Activity = activity;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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
	private String item;
	private String cost;
	private String Activity; // �ִ� �μ�
	private String deleteFlag;



	

}
