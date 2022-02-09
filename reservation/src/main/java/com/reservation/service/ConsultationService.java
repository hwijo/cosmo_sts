package com.reservation.service;

import java.util.List;

import com.reservation.dto.ConsultationDto;
import com.reservation.entity.ConsultationEntity;

public interface ConsultationService {
	
	public List<ConsultationEntity> selectConsultation();
	
	public ConsultationEntity insertConsultation(ConsultationDto consultationDto);
	
	public ConsultationEntity selectByNo(int no);
	
	// 상담 글 등록 한 후 등록한 글의 no를 가져와서 업데이트
	public int insertReply(ConsultationDto consultationDto);

	//public ConsultationEntity updateReply(int grno);

	//public Long savePost(ConsultationDto dto);
	
}
