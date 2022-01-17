package com.reservation.service;

import java.util.List;

import com.reservation.dto.NoticeDto;
import com.reservation.entity.NoticeEntity;

public interface NoticeService {
	public List<NoticeEntity> selectNotice();
	
	public NoticeEntity selectByNo(int no);
	
	public NoticeEntity insertNotice(NoticeDto noticeDto);
}
