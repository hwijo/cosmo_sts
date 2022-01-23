package com.reservation.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dto.ConsultationDto;
import com.reservation.entity.ConsultationEntity;
import com.reservation.repository.ConsultationRepository;



@Service
public class ConsultationServiceImpl implements ConsultationService {		
	
	@Autowired
	public ConsultationRepository consultationRepository;

	

	@Override
	public ConsultationEntity insertConsultation(ConsultationDto consultationDto) {
		ConsultationEntity consultationEntity = new ConsultationEntity();
		ModelMapper modelMapper = new ModelMapper();
		consultationEntity = modelMapper.map(consultationDto, ConsultationEntity.class);
		return consultationRepository.save(consultationEntity);
	}


	@Override
	public List<ConsultationEntity> selectConsultation() {
		return consultationRepository.findAll();
	}


	@Override
	public ConsultationEntity selectByNo(int no) {
		return consultationRepository.findByNo(no);
	}


	@Override
	public ConsultationEntity insertReply(ConsultationDto consultationDto) {
		ConsultationEntity consultationEntity = new ConsultationEntity();
		ModelMapper modelMapper = new ModelMapper();
		consultationEntity = modelMapper.map(consultationDto, ConsultationEntity.class);
		return consultationRepository.save(consultationEntity);
	}
	

	
}

	
