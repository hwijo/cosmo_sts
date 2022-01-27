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

import com.reservation.entity.ReserveEntity;


@Repository
public interface ReserveRepository extends JpaRepository<ReserveEntity, Long> {
	
	
	@Transactional 
	@Modifying
	@Query("select r from ReserveEntity r where r.startDate = :startDate or r.endDate = :endDate")
	List<ReserveEntity> selectReserveByDate(@Param(value="startDate") String startDate, @Param(value="endDate") String endDate);
	
	List<ReserveEntity> findByStartDateLikeOrEndDateLike(String startDate, String endDate);



}
