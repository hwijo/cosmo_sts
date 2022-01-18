package com.reservation.myapp;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
	

	
	
}
