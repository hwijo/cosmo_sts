package com.reservation.myapp;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reservation.dto.ConsultationDto;
import com.reservation.dto.NoticeDto;
import com.reservation.entity.ConsultationEntity;
import com.reservation.service.ConsultationService;





@Controller
public class ConsultationController {
	
	
	
	@Autowired
	ConsultationService consultationService;
	

	
	// 상담 페이지
	@RequestMapping(value = "/consultation", method = RequestMethod.GET)
	public String consultationPage(Model model) {
		
		List<ConsultationEntity> list = consultationService.selectConsultation();
		
		model.addAttribute("list", list);
		
		
		return "consultation";	
		
	}
	
	// 답글 쓰기 페이지 들어가기
	@RequestMapping(value = "/consulReply", method = RequestMethod.GET)
	public String inConsulReply(Model model, HttpServletRequest request, int no) {
		//System.out.println("시발" + no);
		ConsultationEntity e = consultationService.selectByNo(no);
		
		System.out.println(e);
		
		model.addAttribute("e", e);
		
		return "consulReply";	
		
	}
	
	
	// 답글 쓰기 
	@RequestMapping(value = "/consulReply", method = RequestMethod.POST)
	public String consulReply(Model model, HttpServletRequest request) {
		
		ConsultationDto dto = new ConsultationDto();
		
	    int grno = Integer.parseInt(request.getParameter("grno"));
	    int grgrod = Integer.parseInt(request.getParameter("grgrod"));
	    int depth = Integer.parseInt(request.getParameter("depth"));
	    String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		
		dto.setGrno(grno);
		dto.setGrgrod(grgrod+1);
		dto.setDepth(depth+1);
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setName(name);
		dto.setPasswd(passwd);
		
		dto.setLockFlg("0");
		dto.setDeleteFlg("0");
		dto.setBuildCd(2);	
		
		consultationService.insertReply(dto);
		
				
		return "redirect:/consultation";	
		
	}
	

	
	
}
