package com.reservation.repository;



import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.reservation.entity.NoticeEntity;



//단위테스트를 스프링과 연동
@RunWith(SpringJUnit4ClassRunner.class)
//환경설정 파일 명시
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class NoticeRepositoryTest {
	
	@Autowired
	private NoticeRepository noticeRepository;
	

	@Test
	public void insertNotice() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			NoticeEntity noticeEntity = NoticeEntity.builder()
					.title("title" + i)
					.contents("hello")
					.buildCd(2)
					.build();	
			
			noticeRepository.save(noticeEntity);
					   
		});
		
		
	}

/*	
	@Test
	public void insertN() {
		NoticeEntity n = new NoticeEntity();
		n.setTitle("이름");
		n.setContents("내용");
		noticeRepository.insertN(n);
	}
*/	

}
