package com.reservation.repository;



import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Optional;
import com.reservation.entity.NoticeEntity;
import com.reservation.entity.ReserveEntity;
import com.reservation.entity.RoomInfoEntity;
import com.reservation.entity.RoomInfoEntity;


//단위테스트를 스프링과 연동
@RunWith(SpringJUnit4ClassRunner.class)
//환경설정 파일 명시
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class ReserveRepositoryTest {
	
	@Autowired
	private ReserveRepository reserveRepository;


	@Test
	//@Transactional
	public void insertReserve() {
		
		
		//IntStream.rangeClosed(1, 10).forEach(i -> {
		RoomInfoEntity roomInfo = RoomInfoEntity.builder().no(60).build();
		
			ReserveEntity reserveEntity = ReserveEntity.builder()
					.name("user1")
					.phone("01012345678")
					.adult("2")
					.child("2")
					.startDate("2022-01-17")
					.endDate("2022-01-20")
					.paymentFlg("0")
					.totalcost(100000)
					.cancelFlg("0")
					.bankName("신한")
					.bankBranchCde("01")
					.bankNo("01")
					.deleteFlg("0")
					.buildCd(2)		
					.roomInfoEntity(roomInfo)
					.build();	
			
			reserveRepository.save(reserveEntity);
					   
		//});
		
		
	}
	
/*	
	@Test
	public void testRead() { // 답글 하나도 없는 댓글 생성
		Optional<ReserveEntity> result = ReserveRepository.findById(100L);
		

		
		
	}
*/
	

}
