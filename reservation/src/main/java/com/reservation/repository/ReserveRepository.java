package com.reservation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.dto.ReserveDto;
import com.reservation.entity.ReserveEntity;
import com.reservation.entity.RoomInfoEntity;


public interface ReserveRepository extends JpaRepository<ReserveEntity, Integer> {
	
	
	@Transactional 
	@Modifying
	@Query("select r from ReserveEntity r where r.startDate = :startDate or r.endDate = :endDate")
	List<ReserveEntity> selectReserveByDate(@Param(value="startDate") String startDate, @Param(value="endDate") String endDate);
	
	List<ReserveEntity> findByStartDateLikeOrEndDateLike(String startDate, String endDate);

    List<ReserveEntity> findByStartDateLike(String startDate);
    
    
	// 특정 방에 예약된 날짜를 찾는 쿼리(풀캘린더에서 사용)
	@Transactional 
	@Modifying
	@Query("select r from ReserveEntity r join RoomInfoEntity room on r.roomNum = room.no where room.no = :no")
	List<ReserveEntity> selectReserveDate(@Param(value="no") int no);
    // 쿼리에는 테이블명, 컬럼명이 아닌 entity 참고해서 작성할 것
	
	// 전체 예약일을 찾는 쿼리
	@Transactional 
	@Modifying
	@Query("select r.startDate, r.endDate, room.roomTitle, room.colorCd from ReserveEntity r join RoomInfoEntity room on r.roomNum = room.no")
	List<Object[]> selectReserve();
	
	
	// 예약 확인해주는 쿼리(paymentFlg 변경)
	@Transactional 
	@Modifying
	@Query("UPDATE ReserveEntity r SET r.paymentFlg = 1 WHERE r.no = :no")
	public int updateFlg(@Param("no")int no);


   
}
