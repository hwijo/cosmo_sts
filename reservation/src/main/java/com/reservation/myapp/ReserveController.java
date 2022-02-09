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
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.reservation.dto.CalendarDto;
import com.reservation.dto.ReserveDto;
import com.reservation.dto.RoomInfoDto;
import com.reservation.entity.ReserveEntity;
import com.reservation.entity.RoomInfoEntity;
import com.reservation.repository.ReserveRepository;
import com.reservation.service.NoticeService;
import com.reservation.service.ReserveService;
import com.reservation.service.RoomInfoService;

import net.sf.json.JSONArray;



// ����

@Controller
public class ReserveController {
	

	@Autowired 
	ReserveRepository reserveRepository;
	
	@Autowired 
	ReserveService reserveService;
	
	@Autowired
	RoomInfoService roomInfoService;
	
	
	@RequestMapping(value = "/calendar", method = RequestMethod.GET) 
	public String fullcalendar() {
		
		return "main/fullcalendar";
	}
	
	
	// 풀 캘린더	
	@ResponseBody 
	@RequestMapping(value = "/fullcalendar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object[]>> calendar(/* @PathVariable int no */){
		//Map<String, Object> retVal = new HashMap<String, Object>();
				
		List<Object[]> result = reserveService.selectReserve();
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=utf-8");
	    
	    System.out.println(result);
	    

	    return new ResponseEntity<>(result, headers, HttpStatus.OK);
	    

	}

	
	

	
	// 예약 페이지 들어가기(방 리스트에서 선택)
	@RequestMapping(value = "/reserve", method = RequestMethod.GET) // �ش� ���� Ÿ�� ����
	public String inReserve(Model model, HttpServletRequest request, int no) throws JsonProcessingException {
		
		RoomInfoEntity selectRoom = roomInfoService.selectRoomById(no);
		
		model.addAttribute("room", selectRoom);
		

		// 예약된 날짜 선택 안되게
		List<ReserveEntity> reserveDate = reserveService.selectReserveDate(no);		
		if(reserveDate != null) {
		    model.addAttribute("date", reserveDate);		
		}		
		return "main/reserve";		
		
	}
	

	
	
	// 예약하기
	@RequestMapping(value = "/reserve", method = RequestMethod.POST)
	public String reserve(HttpServletRequest request, int no) {
		
		// ReserveEntity entity = new ReserveEntity();
		ReserveDto dto = new ReserveDto();	
		
		//int no = Integer.parseInt(request.getParameter("no"));
		//String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String adult = request.getParameter("adult"); // ���� ��
		String child = request.getParameter("child"); // ���� ��
		String startDate = request.getParameter("startDate"); // ���� ���� ��¥
		String endDate = request.getParameter("endDate"); // ���� �� ��¥
		//int totalcost = Integer.parseInt(request.getParameter("totalcost"));
		String bankName = request.getParameter("bankName");
		//String bankBranchCde = request.getParameter("bankBranchCde"); // ������ȣ
		//String bankNo = request.getParameter("bankNo");	// ���¹�ȣ	
		
		//int roomNum = Integer.parseInt(request.getParameter("roomNum"));
		
		System.out.println(no);
		
		//dto.setName(name);		
		dto.setPhone(phone);
		dto.setAdult(adult);
		dto.setChild(child);
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		//dto.setTotalcost(totalcost);
		dto.setBankName(bankName);
		//dto.setBankBranchCde(bankBranchCde);
		//dto.setBankNo(bankNo);		
		
		// ������
		//dto.setOptions("����");
		dto.setName("kim");
		dto.setPaymentFlg("0");
		dto.setCancelFlg("0");
		dto.setDeleteFlg("0"); 
		dto.setBuildCd(2); 
		
		//dto.setRoomNo(1);
		dto.setRoomNum(no);
		//dto.setRoomInfoEntity(RoomInfoEntity.builder().no(no).build());
		
		reserveService.insertReserve(dto);
		
		
		return "redirect:/";
		
		
	}		

	
	// 예약 가능한 방 리스트 검색(취소)
/*	@RequestMapping(value = "/canReserveList", method = RequestMethod.GET) // �ش� ���� Ÿ�� ����
	public String inReserve(Model model, HttpServletRequest request, @RequestParam(value="startDate") 
								String startDate, @RequestParam(value="endDate") String endDate) {		
				
	    System.out.println("입실일 : " + startDate); // 잘 넘어옴
		

		// 예약 가능한 날짜 찾기
		//List<ReserveEntity> search = reserveService.searchReserve(startDate);
		
        //model.addAttribute("search", search);
	    
	    // 예약 리스트
	    List<ReserveDto> reserveList = reserveService.selectReserve();

		
		// 예약 가능한 방 리스트 찾기
        List<RoomInfoDto> roomList = roomInfoService.selectRoom(startDate, endDate);
		System.out.println("방 리스트 : " + roomList);
		
		for(int i=0; i<roomList.size(); i++) {
			if(startDate == reserveList.get(i).getStartDate()) {
				System.out.println("예약 불가능한 방입니다.");
				
			}
			else {
				System.out.println("예약 가능한 방 : " + roomList);
				model.addAttribute("room", roomList);				
			}
		
		}
		
		return "main/canReserveList";	
	
		
	}
	
*/


}
