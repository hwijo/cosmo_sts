package com.reservation.repository;



import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.reservation.entity.ConsultationEntity;
import com.reservation.repository.ConsultationRepository;


//단위테스트를 스프링과 연동
@RunWith(SpringJUnit4ClassRunner.class)
//환경설정 파일 명시
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class ConsultationRepositoryTest {
	
	@Autowired
	private ConsultationRepository consultationRepository;	

	@Test
	public void insertConsultation() { // 답글 하나도 없는 댓글 생성
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ConsultationEntity consultationEntity = ConsultationEntity.builder()
					.name("김" + i)
					.grno(i)
					.grgrod(0)
                    .depth(0)					
					.title("title" + i)
					.contents("hello")
					.passwd("1234")
					.build();	
			
			consultationRepository.save(consultationEntity);
					   
		});
		
		
	}

	

}
