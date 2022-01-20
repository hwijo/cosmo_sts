package com.reservation.repository;



import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.entity.NoticeEntity;
import com.reservation.entity.ReserveEntity;
import com.reservation.entity.RoomInfoEntity;


//단위테스트를 스프링과 연동
@RunWith(SpringJUnit4ClassRunner.class)
//환경설정 파일 명시
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class ReserveRepositoryTest {
	
	@Autowired
	private ReserveRepository reserveRepository;
	
	@Autowired
	private RoomInfoRepository roomInfoRepository;
	

	@Test
	//@Transactional
	public void insertReserve() {
		
		//RoomInfoEntity r = roomInfoRepository.findByRoomNum(2);
		
		//IntStream.rangeClosed(1, 10).forEach(i -> {
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
					.roomNum(2)
					.build();	
			
			reserveRepository.save(reserveEntity);
					   
		//});
		
		
	}

	

}
