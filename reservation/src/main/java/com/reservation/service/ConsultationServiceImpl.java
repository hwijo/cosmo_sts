package com.reservation.service;



import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.dto.ConsultationDto;
import com.reservation.entity.ConsultationEntity;
import com.reservation.repository.ConsultationRepository;



@Service
public class ConsultationServiceImpl implements ConsultationService {		
	
	@Autowired
	public ConsultationRepository consultationRepository;
	

	

	@Override
	public ConsultationEntity insertConsultation(ConsultationDto consultationDto) {
		ConsultationEntity consultationEntity = dtoToEntity(consultationDto);
		return consultationRepository.save(consultationEntity);
	}



	@Override
	public ConsultationEntity selectByNo(int no) {
		//System.out.println("findByNo : " + consultationRepository.findByNo(no));
		return consultationRepository.findByNo(no);
		
	}

    // 상담, 답글 등록
	@Transactional
	@Override
	public int insertReply(ConsultationDto consultationDto) {
		ConsultationEntity consultationEntity = dtoToEntity(consultationDto);
		System.out.println("insertReply: "+consultationDto);
		if(0 == consultationDto.getGrno()) { // 원글
			Function<ConsultationEntity, ConsultationDto> fn = (entity -> entityToDTO(entity));
			
			ConsultationEntity entity = consultationRepository.save(consultationEntity);
			System.out.println(entity);
			
			int grno = entity.getNo();
			
			System.out.println(grno);
			
			return consultationRepository.updateReply(grno);
		} else { // 답글
			consultationRepository.updateReplyGrgrod(consultationDto.getGrgrod());
			System.out.println("insertReplyEntity: "+consultationEntity.toString());
			ConsultationEntity entity = consultationRepository.save(consultationEntity);
			return entity.getNo(); 
		}
		
		
		
		 
	}


	// 원글, 답글, 답글의 답글 등 순서대로 출력
	@Override
	public List<ConsultationDto> selectConsultation() {
		Function<ConsultationEntity, ConsultationDto> fn = (entity -> entityToDTO(entity));
		List<ConsultationEntity> entity = consultationRepository.selectConsultationList();
		List<ConsultationDto> result = entity.stream().map(fn).collect(Collectors.toList());
		return result;
	}
	




	
}

	
