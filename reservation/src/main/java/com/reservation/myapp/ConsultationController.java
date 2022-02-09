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
	
	
	// 상담 리스트
	@RequestMapping(value = "/consultationList", method = RequestMethod.GET)
	public String consultationPage(Model model) {
		
		List<ConsultationEntity> list = consultationService.selectConsultation();
		
		model.addAttribute("list", list);
		
		
		return "main/consultationList";	
		
	}
	
	// 상담 리스트(관리자)
	@RequestMapping(value = "/admin/consultationList", method = RequestMethod.GET)
	public String consultationPageAdmin(Model model) {
		
		List<ConsultationEntity> list = consultationService.selectConsultation();
		
		model.addAttribute("list", list);
		
		
		return "admin/consultationList";	
		
	}
	
	// 상담 상세보기
	@RequestMapping(value = "/consultation", method = RequestMethod.GET)
	public String consultation(Model model, int no) {
		
		ConsultationEntity consul = consultationService.selectByNo(no);
		
		model.addAttribute("consul", consul);		
		
		return "main/consultation";	
		
	}
	
	// 상담 작성 페이지 들어가기
	@RequestMapping(value = "/insertConsultation", method = RequestMethod.GET)
	public String inInsertConsultation(Model model, HttpServletRequest request) {
						
		return "main/insertConsultation";	
		
	}
	
	// 상담 작성
	@RequestMapping(value = "/insertConsultation", method = RequestMethod.POST)
	public String insertConsultation(Model model, HttpServletRequest request) {
				
        ConsultationDto dto = new ConsultationDto();
		
	    //int grno = Integer.parseInt(request.getParameter("grno"));
	    String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		
		//dto.setGrno(grno);
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setName(name);
		dto.setPasswd(passwd);		
		
		dto.setGrgrod(0);
		dto.setDepth(0);
		
		dto.setLockFlg("0");
		dto.setDeleteFlg("0");
		//dto.setBuildCd(2);	
		
		consultationService.insertReply(dto);
		
		//int grno = entity.getGrno();
		//System.out.println(grno);				 
		
				
		return "redirect:/consultationList";		
		
	}
	
	// 답글 쓰기 페이지 들어가기
	@RequestMapping(value = "/admin/consulReply", method = RequestMethod.GET)
	public String inConsulReply(Model model, HttpServletRequest request, int no) {
		//System.out.println("시발" + no);
		ConsultationEntity e = consultationService.selectByNo(no);
		
		System.out.println(e);
		
		model.addAttribute("e", e);
		
		return "admin/consulReply";	
		
	}
	
	
	// 답글 쓰기 
	@RequestMapping(value = "/admin/consulReply", method = RequestMethod.POST)
	public String consulReply(Model model, HttpServletRequest request) {
		
		ConsultationDto dto = new ConsultationDto();
		
	    int grno = Integer.parseInt(request.getParameter("grno"));
	    int grgrod = Integer.parseInt(request.getParameter("grgrod"));
	    int depth = Integer.parseInt(request.getParameter("depth"));
	    String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		
		System.out.println(depth);
		
		if(depth == 1) { // 추가 답글을 달때
			dto.setGrno(grno);
			dto.setGrgrod(grgrod+1);
			dto.setDepth(depth);
			dto.setTitle(title);
			dto.setContents(contents);
			dto.setName(name);
			dto.setPasswd(passwd);
			
			dto.setLockFlg("0");
			dto.setDeleteFlg("0");
			//dto.setBuildCd(2);
			
		}
		else {
			 // 원글에 답글 OR 답글에 답글을 달때
			dto.setGrno(grno);
			dto.setGrgrod(grgrod+1);
			dto.setDepth(depth+1);
			dto.setTitle(title);
			dto.setContents(contents);
			dto.setName(name);
			dto.setPasswd(passwd);
			
			dto.setLockFlg("0");
			dto.setDeleteFlg("0");
			//dto.setBuildCd(2);	
			
      
		}
		
		consultationService.insertReply(dto);
		
				
		return "redirect:/admin/consultationList";	
		
	}
	

	
	
}
