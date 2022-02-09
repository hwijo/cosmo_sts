package com.reservation.myapp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.reservation.dto.RoomInfoDto;
import com.reservation.entity.RoomInfoEntity;
import com.reservation.repository.RoomInfoRepository;
import com.reservation.repository.UserSha256;
import com.reservation.service.RoomInfoService;


@Controller
public class RoomInfoController {	

	@Autowired 
	RoomInfoService roomInfoService;
	
	@Autowired 
	RoomInfoRepository roomInfoRepository;

	
	// 방 리스트
	@RequestMapping(value = "/roomList", method = RequestMethod.GET)
	public String roomList(Model model, HttpServletRequest request) {
		
		List<RoomInfoDto> roomList = roomInfoService.selectRoom();
		System.out.println("방 리스트 : " + roomList);
		
		model.addAttribute("room", roomList);		
		
		return "main/roomList";
		

	}

	
	// 방 등록 페이지 들어가기
	@RequestMapping(value = "/admin/insertRoom", method = RequestMethod.GET)
	public String inInsertRoom() {				
		
		return "admin/insertRoom";		
		
	}
	
	
	// 방 등록
	@RequestMapping(value = "/admin/insertRoom", method = RequestMethod.POST)
	public String insertRoom(HttpServletRequest request, @RequestParam("image") MultipartFile uploadFile) {
		
		RoomInfoEntity en = new RoomInfoEntity();
		
		//RoomInfoDto dto = new RoomInfoDto();
			
		//String roomNum = request.getParameter("roomNum");
		String roomTitle = request.getParameter("roomTitle");
		int max = Integer.parseInt(request.getParameter("max"));
		int adultCost = Integer.parseInt(request.getParameter("adultCost"));
		int childCost = Integer.parseInt(request.getParameter("childCost"));
		String explnation = request.getParameter("explnation");
		String colorCd = request.getParameter("colorCd");
		
		// ���� ���ε� ó��
		String fileName = null; // ���� �̸�
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename(); // �����̸� ���ϱ�
			String ext = FilenameUtils.getExtension(originalFileName); // Ȯ���� ���ϱ�
			String images = UserSha256.encrypt(originalFileName); // sha256 ��ȣȭ
			System.out.println(originalFileName);
			fileName = images + "." + ext;
			try {
				uploadFile.transferTo(new File("C:\\Users\\1\\git\\cosmo_sts\\reservation\\src\\main\\webapp\\resources\\roomimages\\" + fileName)); // �̹��� ���� ���
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}   
				
		//entity.setRoomNum(roomNum);		
		en.setRoomTitle(roomTitle);
		en.setMax(max);
		en.setAdultCost(adultCost);
		en.setChildCost(childCost);
		en.setExplnation(explnation);
		en.setImages(fileName);
		en.setColorCd(colorCd);
		
		en.setDeleteFlg("0"); // ������
		en.setBuildCd(2); // ������
		
		roomInfoRepository.save(en);
		
		System.out.println("�̹��� ���� �Ϸ�");
		
		return "redirect:/admin";
		
		
	}		





}
