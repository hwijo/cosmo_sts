package com.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.dto.ConsultationDto;
import com.reservation.entity.ConsultationEntity;
import com.reservation.entity.ReserveEntity;

@Repository
public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {
	
	public ConsultationEntity findByGrno(int grno);
	
	public ConsultationEntity findByNo(int no);
	
	//public ConsultationEntity findById((long)dto.getG));
/*	
	// 답글
	@Transactional 
	@Modifying
	@Query("insert into Consultation grno, grgrod, depth, title, contents, name, passwd, "
			+ "createDat, updateDat, buildCd values #{grno}, #{grgrod}+1, #{depth}, #{title}, #{contents}, "
			+ "#{name}, #{passwd}, NOW(), NOW(), '2'")
	public ConsultationEntity insertReply(@Param(value="consul2") ConsultationEntity consul2);
*/

/*	
	// 원글에 답글을 다는 쿼리
	@Transactional 
	@Modifying
	@Query("insert into ConsultationEntity c values (c.grno = :gron, c.grgrod = :grgrod +1, c.depth = :depth+1)
	public List<ConsultationDto> selectConsultationList();
	List<ReserveEntity> selectReserveDate(@Param(value="no") int no);
*/	
	


		
	// 원글, 답글 순서대로 보여주는 쿼리
	@Transactional 
	@Modifying
	@Query("select c from ConsultationEntity c order by c.grno desc, c.grgrod asc")
	public List<ConsultationEntity> selectConsultationList();
    // 쿼리에는 테이블명, 컬럼명이 아닌 entity 참고해서 작성할 것
	
	// 시퀸스 no를 grno에 넣어서 업데이트하는 쿼리
	@Transactional 
	@Modifying
	@Query("UPDATE ConsultationEntity c SET c.grno = :grno WHERE c.grno = 0")
	public int updateReply(@Param("grno")int grno);
	
	// 답글 하나 더 추가
	@Modifying
	@Query("UPDATE ConsultationEntity c SET c.grgrod = c.grgrod+1 WHERE c.grgrod >= :grgrod")
	public int updateReplyGrgrod(@Param("grgrod")int grgrod);
	

	
	
/*
	// grno에 맞는 리스트 찾아오기
	@Transactional 
	@Modifying
	@Query("SELECT c ConsultationEntity c FROM ConsultationEntity WHERE c.grno = :grno")
	public List<ConsultationEntity> selectConsultationListGrno(@Param("grno")int grno);
	
	// 답글 중 grgrod가 가장 큰 글 찾기
/*	@Transactional 
	@Modifying
	@Query("SELECT c FROM ConsultationEntity WHERE max(c.grgrod")
	public ConsultationEntity selectMaxGrno();
	
	// 리스트에서 grgrod가 가장 큰 값 찾기
	@Transactional 
	@Modifying
	@Query("SELECT max(c.grgrod) c FROM ConsultationEntity WHERE c.grno = :grno")
	public int selectMaxGrno(@Param("grno")int grno);
*/	

	
	
/*		
	@Transactional 
	@Modifying
	@Query(value = "UPDATE ConsultaionEntity c SET c.grgrod=c.grgrod + 1 where c.grno = :grno and c.grgrod > : grgrod", nativeQuery = true)
	public String updateConsultation(@Param("grno")int grno, @Param("grgrod")int grgrod);
	
	@Query(value = "SELECT min(c.grgrod) from Consultaion c where c.grno = :grno and grgrod and c.depth <= :depth", nativeQuery = true)
	public String equalOrder(@Param("grno")int grno, @Param("grgrod")int grgrod, @Param("depth")int depth);
	
	@Query(value = "SELECT max(c.grgrod) + 1 from Consultaion c where c.grno = :grno", nativeQuery = true)
	public int resultOrder(@Param("grno")int grno);

	@Query(value = "UPDATE Consultaion c SET c.grgrod=c.grgrod + 1 where c.grno = :grno and c.grgrod >= :yz", nativeQuery = true)
	public String updateOrder(@Param("grno")int grno, @Param("grgrod")int grgrod, @Param("yz")int yz);
*/	
	//@Query("SELECT c FROM Consultation c where c.title = :title or c.contents = :contents order by c.grno desc, c.depth asc, c.grgrod asc")
	//Page<ConsultationEntity> all(@Param("title")String title, @Param("contents")String contents, Pageable pageable);

	
}
