package com.reservation.service;




import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.dto.ReserveDto;
import com.reservation.dto.RoomInfoDto;
import com.reservation.entity.ReserveEntity;
import com.reservation.entity.RoomInfoEntity;
import com.reservation.repository.RoomInfoRepository;

@Service
public class RoomInfoServiceImp implements RoomInfoService {

	@Autowired
	private RoomInfoRepository roomInfoRepository;
	
	@Transactional
	@Override
	public List<RoomInfoDto> selectRoom() {
		List<RoomInfoEntity> roomInfoEntities = roomInfoRepository.findAll();
		List<RoomInfoDto> roomInfoDtoList = new ArrayList<>();
		
		if(roomInfoEntities.isEmpty()) 
			return roomInfoDtoList;
		for(RoomInfoEntity roomInfo : roomInfoEntities) {
			roomInfoDtoList.add(this.convertEntityToDto(roomInfo));
		}
		
		return roomInfoDtoList;
	}	
	
	@Transactional
	@Override
	public RoomInfoEntity selectRoomById(int no) {		
        return roomInfoRepository.findByNo(no);
        
		/*
		 * RoomInfoDto roomInfoDto = RoomInfoDto.builder() .no(roomInfo.getNo())
		 * .roomNum(roomInfo.getRoomNum()) .roomTitle(roomInfo.getRoomTitle())
		 * .max(roomInfo.getMax()) .adultCost(roomInfo.getAdultCost())
		 * .childCost(roomInfo.getChildCost()) .explnation(roomInfo.getExplnation())
		 * .images(roomInfo.getImages()) .colorCd(roomInfo.getColorCd())
		 * .deleteFlg(roomInfo.getDeleteFlg()) .createdAt(roomInfo.getCreatedAt())
		 * .updatedAt(roomInfo.getUpdatedAt()) .buildCd(2) .build();
		 * 
		 * return roomInfoDto;
		 */
        
		/*
		 * RoomInfoEntity roomInfo = new RoomInfoEntity(); RoomInfoDto roomInfoDto =
		 * roomInfoRepository.findByNo(); roomInfoDto = convertEntityToDto(roomInfo);
		 * return roomInfoDto;
		 */
	}
	
	
	private RoomInfoDto convertEntityToDto(RoomInfoEntity roomInfo) {
        return RoomInfoDto.builder()
        		.no(roomInfo.getNo())
				.roomNum(roomInfo.getRoomNum())
				.roomTitle(roomInfo.getRoomTitle())
				.max(roomInfo.getMax())
				.adultCost(roomInfo.getAdultCost())
				.childCost(roomInfo.getChildCost())
				.explnation(roomInfo.getExplnation())
				.images(roomInfo.getImages())
				.colorCd(roomInfo.getColorCd())
				.deleteFlg(roomInfo.getDeleteFlg())
				.createdAt(roomInfo.getCreatedAt())
				.updatedAt(roomInfo.getUpdatedAt())
				.buildCd(2)		
				.build();	
        		
    }



	
}
