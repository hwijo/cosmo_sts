package com.reservation.service;



import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.dto.ConsultationDto;
import com.reservation.dto.NoticeDto;
import com.reservation.entity.ConsultationEntity;
import com.reservation.entity.NoticeEntity;
import com.reservation.repository.NoticeRepository;


@Service
public class NoticeServiceImpl implements NoticeService {		
	
	@Autowired
	public NoticeRepository noticeRepository;
	
	
	
	public List<NoticeEntity> selectNotice() {
		return noticeRepository.findAll();
	}


	@Override
	public NoticeEntity selectByNo(int no) {
		return noticeRepository.findByNo(no);
	}
	
	
	// 공지사항 등록
	@Transactional
	@Override
	public NoticeDto updateNotice(NoticeDto dto) {
		NoticeEntity noticeEntity = dtoToEntity(dto);
		
		System.out.println("insertNotice: " + dto);
		
		NoticeEntity entity = noticeRepository.save(noticeEntity);
		
		System.out.println("entity : " + entity);
		
		return entityToDto(entity);
		
		//System.out.println(dto);
		
		//NoticeEntity entity = noticeRepository.findById(dto.getNo()).get();
		/*
		if(dto.getDeleteFlg() != null) { // deleteFlg가 0일때
			entity.setDeleteFlg(dto.getDeleteFlg());
		}
		
		else if(dto.getLockFlg() != null) { // lockFlg가 0일때
			entity.setLockFlg(dto.getLockFlg());
		}
		*/
		//if(dto.getNo() != 0) {  // 등록된 글이 없을 때
		//	noticeRepository.save(entity); // 글 등록
		//}
		
		//System.out.println(entity);
		
		//noticeRepository.save(entity);
		
		//return entityToDto(entity);
	}


	@Override
	public NoticeEntity insertNotice(NoticeDto noticeDto) {
		NoticeEntity noticeEntity = new NoticeEntity();
		ModelMapper modelMapper = new ModelMapper();
		noticeEntity = modelMapper.map(noticeDto, NoticeEntity.class);
		return noticeRepository.save(noticeEntity);
	}
	

	
}

	
