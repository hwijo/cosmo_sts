package com.reservation.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.dto.RoomInfoDto;
import com.reservation.entity.RoomInfoEntity;



@Repository
public interface RoomInfoRepository extends JpaRepository<RoomInfoEntity, Long> {

	RoomInfoEntity findByNo(int no);
	
	//RoomInfoEntity findByRoomNum(int roomNum);
	
	// 이미 예약된 방을 찾는 쿼리
	@Transactional 
	@Modifying
	@Query("select room from ReserveEntity r join RoomInfoEntity room on r.roomNum = room.no where r.startDate like %:startDate% or r.endDate like %:endDate%")
	List<RoomInfoEntity> selectRoomCan(@Param(value="startDate") String startDate, @Param(value="endDate") String endDate);
    // 쿼리에는 테이블명, 컬럼명이 아닌 entity 참고해서 작성할 것


}
