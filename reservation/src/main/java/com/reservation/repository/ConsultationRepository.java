package com.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.entity.ConsultationEntity;

@Repository
public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {
	
	public ConsultationEntity findByGrno(int grno);
	
	public ConsultationEntity findByNo(int no);
/*	
	// 답글
	@Transactional 
	@Modifying
	@Query("insert into Consultation grno, grgrod, depth, title, contents, name, passwd, "
			+ "createDat, updateDat, buildCd values #{grno}, #{grgrod}+1, #{depth}, #{title}, #{contents}, "
			+ "#{name}, #{passwd}, NOW(), NOW(), '2'")
	public ConsultationEntity insertReply(@Param(value="consul2") ConsultationEntity consul2);
*/
}
