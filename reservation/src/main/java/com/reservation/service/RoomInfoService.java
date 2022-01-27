package com.reservation.service;




import java.util.List;

import com.reservation.dto.RoomInfoDto;
import com.reservation.entity.RoomInfoEntity;

public interface RoomInfoService {	
	public List<RoomInfoDto> selectRoom();

	public RoomInfoEntity selectRoomById(int no);
}
