package com.reservation.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.entity.RoomInfoEntity;
import com.reservation.repository.RoomInfoRepository;

@Service
public class RoomInfoServiceImp implements RoomInfoService {

	@Autowired
	private RoomInfoRepository roomInfoRepository;
	
	@Override
	public List<RoomInfoEntity> selectRoom() {
		return roomInfoRepository.findAll();
	}	
	
}
