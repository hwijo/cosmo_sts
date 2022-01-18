package com.reservation.service;

import java.util.List;

import com.reservation.dto.ConsultationDto;
import com.reservation.entity.ConsultationEntity;

public interface ConsultationService {
	
	public List<ConsultationEntity> selectConsultation();
	
	public ConsultationEntity insertConsultation(ConsultationDto consultationDto);
}
