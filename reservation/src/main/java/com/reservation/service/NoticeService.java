package com.reservation.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dto.NoticeDto;
import com.reservation.entity.NoticeEntity;
import com.reservation.repository.NoticeRepository;


@Service
public class NoticeService {		
	
	@Autowired
	public NoticeRepository noticeRepository;
	
	@Autowired
	public NoticeEntity noticeEntity;
	
	@Autowired
	public ModelMapper modelMapper;	
	
	
	public List<NoticeEntity> selectNotice() {
		return noticeRepository.findAll();
	}
	
/*
	public NoticeEntity insertNotice(NoticeDto noticeDto) {
		noticeEntity = modelMapper.map(noticeDto, NoticeEntity.class);
		return noticeRepository.save(noticeEntity);
		
	}

	public NoticeEntity selectByNo(int no) {
		return noticeRepository.findByNo(no);
	}
*/
	

	
}

	
