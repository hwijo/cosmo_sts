package com.reservation.repository;



import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;


//단위테스트를 스프링과 연동
@RunWith(SpringJUnit4ClassRunner.class)
//환경설정 파일 명시
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class RoomInfoRepositoryTest {
	
	@Autowired
	private RoomInfoRepository roomInfoRepository;	

	@Test
	public void selectRoomInfo() { 
		System.out.println(roomInfoRepository.findAll());
		
	}
/*     
	@Test
	public void insertReply() {
		ConsultationEntity consul1 = consultationRepository.findByGrno(1);
		ConsultationEntity consul2 = new ConsultationEntity();
		log.info(consultationRepository.findByGrno(1).toString());
		consul2.setGrno(consul1.getGrno());
		consul2.setGrgrod(consul1.getGrgrod() + 1);
		consul2.setDepth(consul1.getDepth() + 1);
		consul2.setTitle("답글1입니다.");
		consul2.setName("답글1 등록자");
		consul2.setPasswd("1234");
		
		log.info(consul2.toString());

		consultationRepository.save(consul2);
	}
*/
	

}
