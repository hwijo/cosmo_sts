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


@Repository
public interface ReserveRepository extends JpaRepository<ReserveEntity, Long> {
	
	
	@Transactional 
	@Modifying
	@Query("select r from ReserveEntity r where r.startDate = :startDate or r.endDate = :endDate")
	List<ReserveEntity> selectReserveByDate(@Param(value="startDate") String startDate, @Param(value="endDate") String endDate);
	
	List<ReserveEntity> findByStartDateLikeOrEndDateLike(String startDate, String endDate);

    List<ReserveEntity> findByStartDateLike(String startDate);
    
    
	// 예약된 날짜를 찾는 쿼리
	@Transactional 
	@Modifying
	@Query("select r from ReserveEntity r join RoomInfoEntity room on r.roomNum = room.no where room.no = :no")
	List<ReserveEntity> selectReserveDate(@Param(value="no") int no);
    // 쿼리에는 테이블명, 컬럼명이 아닌 entity 참고해서 작성할 것

   
}
