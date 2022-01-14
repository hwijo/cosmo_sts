package com.reservation.myapp;


import java.util.List;


import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reservation.entity.NoticeEntity;
import com.reservation.entity.SliderimagesEntity;
import com.reservation.repository.NoticeRepository;
import com.reservation.repository.RoomInfoRepository;
import com.reservation.repository.SliderimagesRepository;




/**
 * Handles requests for the application home page.
 */
@Controller
public class NoticeController {
	
	@Autowired 
	NoticeRepository noticeRepository;

	@Autowired 
	RoomInfoRepository roomInfoRepository;
	
	@Autowired
	SliderimagesRepository sliderimagesRepository;
	
	// 메인(슬라이드, 공지사항 리스트)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String noticeList(Model model) {
		
		List<SliderimagesEntity> list = sliderimagesRepository.findAll();
		// sort는 select할때 해주자
		
		model.addAttribute("images", list);		
	
		
		List<NoticeEntity> notice = noticeRepository.findAll();
		System.out.println("log : " + notice);
		
		model.addAttribute("notice", notice);		
		
		
		return "home";	
		
	}
	
	// 공지사항 상세보기
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(Model model, HttpServletRequest request, int no) {

		// int no = Integer.parseInt(request.getParameter("no"));

		NoticeEntity sn = noticeRepository.findByNo(no);

		System.out.println("log : " + sn);

		model.addAttribute("sn", sn);

		return "notice";

	}

	// 공지사항 등록 페이지 들어가기
	@RequestMapping(value = "/insertNotice", method = RequestMethod.GET)
	public String inInsertNotice(Model model, HttpServletRequest request) {

		return "insertNotice";

	}

	// 공지사항 등록
	@RequestMapping(value = "/insertNotice", method = RequestMethod.POST)
	public String insertNotice(Model model, HttpServletRequest request) {

		//NoticeDto dto = new NoticeDto();
		NoticeEntity e = new NoticeEntity();

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

	    e.setTitle(title);
		e.setContents(contents);
		e.setDeleteFlg("0"); // 고정값
		e.setBuildCd(2); // 고정값

		System.out.println("notice 저장 코드 시작");
		noticeRepository.save(e);
		System.out.println("notice 저장 코드 끝");

		return "redirect:/";

	}
	
	
}
