package com.reservation.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dto.NoticeDto;
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


	@Override
	public NoticeEntity insertNotice(NoticeDto noticeDto) {
		NoticeEntity noticeEntity = new NoticeEntity();
		ModelMapper modelMapper = new ModelMapper();
		noticeEntity = modelMapper.map(noticeDto, NoticeEntity.class);
		return noticeRepository.save(noticeEntity);
	}
	

	
}

	
