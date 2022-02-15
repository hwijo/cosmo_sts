package com.reservation.service;

import java.util.List;
import java.util.Optional;

import com.reservation.dto.ConsultationDto;
import com.reservation.entity.ConsultationEntity;

public interface ConsultationService {
	
	public List<ConsultationDto> selectConsultation();
	
	public ConsultationEntity insertConsultation(ConsultationDto consultationDto);
	
	public ConsultationEntity selectByNo(int no);
	
	// 상담 글 등록 한 후 등록한 글의 no를 가져와서 업데이트
	public int insertReply(ConsultationDto consultationDto);


	
	default ConsultationEntity dtoToEntity(ConsultationDto dto) {
		ConsultationEntity entity = ConsultationEntity.builder()
				.no(dto.getNo())
				.name(dto.getName())
				.grno(dto.getGrno())
				.grgrod(dto.getGrgrod())
				.depth(dto.getDepth())
				.title(dto.getTitle())
				.contents(dto.getContents())
				.passwd(dto.getPasswd())
				.lockFlg(dto.getLockFlg())
				.deleteFlg(dto.getDeleteFlg())
				.createdAt(dto.getCreatedAt())
				.updatedAt(dto.getUpdatedAt())
			.build();
		return entity;
	}
	
	default ConsultationDto entityToDTO(ConsultationEntity entity) {
		ConsultationDto dto = ConsultationDto.builder()
				.no(entity.getNo())
				.name(entity.getName())
				.grno(entity.getGrno())
				.grgrod(entity.getGrgrod())
				.depth(entity.getDepth())
				.title(entity.getTitle())
				.contents(entity.getContents())
				.passwd(entity.getPasswd())
				.lockFlg(entity.getLockFlg())
				.deleteFlg(entity.getDeleteFlg())
				.createdAt(entity.getCreatedAt())
				.updatedAt(entity.getUpdatedAt())
			.build();
		return dto;
	}
	
}
