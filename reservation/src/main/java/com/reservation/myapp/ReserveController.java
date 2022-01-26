package com.reservation.myapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.tiles.request.Request;
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

import com.reservation.dto.ReserveDto;
import com.reservation.dto.RoomInfoDto;
import com.reservation.entity.ReserveEntity;
import com.reservation.entity.RoomInfoEntity;
import com.reservation.repository.ReserveRepository;
import com.reservation.service.NoticeService;
import com.reservation.service.ReserveService;
import com.reservation.service.RoomInfoService;



// ����

@Controller
public class ReserveController {
	

	@Autowired 
	ReserveRepository reserveRepository;
	
	@Autowired 
	ReserveService reserveService;
	
	@Autowired
	RoomInfoService roomInfoService;
	
	
	
	// 캘린더
	//@ResponseBody 
	@RequestMapping(value = "/fullcalendar", method = RequestMethod.GET)
	public String calendar(Model model, HttpServletRequest request) {
		
/*		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<ReserveEntity> list = reserveService.selectAll();
		 
		System.out.println(list);
		
	
		map.put("roomNum", list.get(0).getRoomInfoEntity()); 
		map.put("startDate", list.get(0).getStartDate()); 
		map.put("endDate", list.get(0).getEndDate());
		map.put("totalCost", list.get(0).getTotalcost());
		
		
		map.put("list", list);
		
		System.out.println(map); 
		
		model.addAttribute("list", list); */
		
		return "fullcalendar";		
		
	}	
	
	// 예약 페이지 들어가기
	@RequestMapping(value = "/reserve", method = RequestMethod.GET) // �ش� ���� Ÿ�� ����
	public String inReserve(Model model, HttpServletRequest request, String startDate, String endDate) {				
				
		System.out.println("시작일 : " + startDate); // 잘 넘어옴
		
		List<RoomInfoEntity> dto = roomInfoService.selectRoom();
		
		List<ReserveEntity> dto2 = reserveService.selectAll();
		
		List<ReserveEntity> dto3 = reserveService.selectReserveByDate(startDate, endDate);
		
		model.addAttribute("room", dto);
		
		model.addAttribute("reserve", dto2);
		
		model.addAttribute("reserveinfo", dto3);
		
		
		return "main/reserve";		
		
	}
	
	
	// ����
	@RequestMapping(value = "/main/reserve", method = RequestMethod.POST)
	public String reserve(HttpServletRequest request) {
		
		// ReserveEntity entity = new ReserveEntity();
		ReserveDto dto = new ReserveDto();	
		
		int no = Integer.parseInt(request.getParameter("no"));
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
		
		//int roomNum = Integer.parseInt(request.getParameter("roomNum"));
		
		System.out.println(no);
		
		dto.setName(name);		
		dto.setPhone(phone);
		dto.setAdult(adult);
		dto.setChild(child);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		//entity.setTotalcost(totalcost);
		dto.setBankName(bankName);
		dto.setBankBranchCde(bankBranchCde);
		dto.setBankNo(bankNo);
		
		// ������
		dto.setOptions("����");
		dto.setPaymentFlg("0");
		dto.setCancelFlg("0");
		dto.setDeleteFlg("0"); 
		dto.setBuildCd(2); 
		
		//dto.setRoomNo(1);
		//dto.setRoomNum(no);
		dto.setRoomInfoEntity(RoomInfoEntity.builder().no(no).build());
		
		reserveService.insertReserve(dto);
		
		
		return "redirect:/";
		
		
	}		



}
