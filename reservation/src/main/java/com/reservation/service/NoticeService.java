package com.reservation.service;

import java.util.List;

import com.reservation.dto.NoticeDto;
import com.reservation.entity.NoticeEntity;

public interface NoticeService {
	public List<NoticeEntity> selectNotice();
	
	public NoticeEntity insertNotice(NoticeDto noticeDto);
	
	public NoticeEntity selectByNo(int no);

	NoticeDto updateNotice(NoticeDto dto);
	
	default NoticeEntity dtoToEntity(NoticeDto dto) {
		return NoticeEntity.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.contents(dto.getContents())
				.deleteFlg(dto.getDeleteFlg())
				.createdAt(dto.getCreatedAt())
				.updatedAt(dto.getUpdatedAt())
				.buildCd(2)
				.lockFlg(dto.getLockFlg())
				.passwd(dto.getPasswd())
				.build();		
	}
	
	default NoticeDto entityToDto(NoticeEntity notice) {
		return NoticeDto.builder()
				.no(notice.getNo())
				.title(notice.getTitle())
				.contents(notice.getContents())
				.deleteFlg(notice.getDeleteFlg())
				.createdAt(notice.getCreatedAt())
				.updatedAt(notice.getUpdatedAt())
				.buildCd(2)
				.lockFlg(notice.getLockFlg())
				.passwd(notice.getPasswd())
				.build();	
		
	} 
}
