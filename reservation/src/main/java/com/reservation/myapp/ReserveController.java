package com.reservation.myapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reservation.entity.ReserveEntity;
import com.reservation.repository.ReserveRepository;



// ����

@Controller
public class ReserveController {
	

	@Autowired 
	ReserveRepository reserveRepository;
	
	
	
	// Ķ����
	//@ResponseBody // �ڹ� ��ü�� HTTP ���� ������ ��ü�� ��ȯ
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String calendar(Model model, HttpServletRequest request) {
		
		/*
		 * Map<String, Object> map = new HashMap<String, Object>();
		 * 
		 * List<ReserveEntity> list = reserveRepository.findAll();
		 * 
		 * System.out.println(list);
		 */
		/*
		 * map.put("roomInfo_No", list.get(0).getRoomInfo_No()); map.put("startDate",
		 * list.get(0).getStartDate()); map.put("endDate", list.get(0).getEndDate());
		 * map.put("totalCost", list.get(0).getTotalcost());
		 */
		
		//map.put("list", list);
		
		//System.out.println(map);
		
		//model.addAttribute("list", list);
		
		return "calendar";		
		
	}	
	
	// ���������� ����
	@RequestMapping(value = "/reserve", method = RequestMethod.GET) // �ش� ���� Ÿ�� ����
	public String inReserve() {				
		
		return "reserve";		
		
	}
	
	
	// ����
	@RequestMapping(value = "/reserve", method = RequestMethod.POST)
	public String reserve(HttpServletRequest request) {
		
		ReserveEntity entity = new ReserveEntity();
				
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String adult = request.getParameter("adult"); // ���� ��
		String child = request.getParameter("child"); // ���� ��
		String startDate = request.getParameter("startDate"); // ���� ���� ��¥
		String endDate = request.getParameter("endDate"); // ���� �� ��¥
		//int totalcost = Integer.parseInt(request.getParameter("totalcost"));
		String bankName = request.getParameter("bankName");
		String bankBranchCde = request.getParameter("bankBranchCde"); // ������ȣ
		String bankNo = request.getParameter("bankNo");	// ���¹�ȣ	
		
		entity.setName(name);		
		entity.setPhone(phone);
		entity.setAdult(adult);
		entity.setChild(child);
		entity.setStartDate(startDate);
		entity.setEndDate(endDate);
		//entity.setTotalcost(totalcost);
		entity.setBankName(bankName);
		entity.setBankBranchCde(bankBranchCde);
		entity.setBankNo(bankNo);
		
		// ������
		entity.setOptions("����");
		entity.setPaymentFlg("0");
		entity.setCancelFlg("0");
		entity.setDeleteFlg("0"); 
		entity.setBuildCd(2); 
		
		reserveRepository.save(entity);
		
		
		return "redirect:/";
		
		
	}		



}
