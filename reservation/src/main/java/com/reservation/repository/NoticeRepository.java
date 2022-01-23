package com.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.reservation.entity.NoticeEntity;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
	
	NoticeEntity findByNo(int no);
/*
	@Transactional 
	@Modifying
	@Query("insert into Notice n n.title, n.contents "
			+ "values (n.title, n.contents)")
	public NoticeEntity insertN(@Param(value="n") NoticeEntity n);
*/
	
	

}
