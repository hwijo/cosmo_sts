package com.reservation.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservation.dto.RoomInfoDto;
import com.reservation.entity.RoomInfoEntity;



@Repository
public interface RoomInfoRepository extends JpaRepository<RoomInfoEntity, Long> {

	RoomInfoEntity findByNo(int no);
	
	//RoomInfoEntity findByRoomNum(int roomNum);


}
