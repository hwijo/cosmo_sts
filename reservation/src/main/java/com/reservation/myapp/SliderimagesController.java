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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.reservation.entity.SliderimagesEntity;
import com.reservation.repository.SliderimagesRepository;
import com.reservation.repository.UserSha256;




@Controller
public class SliderimagesController {
	
	@Autowired
	SliderimagesRepository sliderimagesRepository;

	
	// �����̵� �̹��� ��� ����
	@RequestMapping(value = "/admin/insertSliderimages", method = RequestMethod.GET)
	public String inInsertSliderimages() {				
		
		return "admin/insertSliderimages";		
		
	}
	
	
	// �����̵� �̹��� 
	@RequestMapping(value = "/admin/insertSliderimages", method = RequestMethod.POST)
	public String insertSliderimages(HttpServletRequest request, @RequestParam("image") MultipartFile uploadFile, Model model) {
		
		SliderimagesEntity entity = new SliderimagesEntity();
					
		// ���� ���ε� ó��
		String fileName = null; // ���� �̸�
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename(); // �����̸� ���ϱ�
			String ext = FilenameUtils.getExtension(originalFileName); // Ȯ���� ���ϱ�
			String images = UserSha256.encrypt(originalFileName); // sha256 ��ȣȭ
			System.out.println(originalFileName);
			fileName = images + "." + ext;
			try {
				uploadFile.transferTo(new File("C:\\Users\\1\\git\\cosmo_sts\\reservation\\src\\main\\webapp\\resources\\" + fileName)); // �̹��� ���� ��� + ����
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}   
				
		entity.setFilename(fileName);	
		entity.setActivity("0");
		entity.setDeleteFlg("0"); // ������
		
		SliderimagesEntity i = sliderimagesRepository.save(entity);
		// sort�� select�Ҷ� ������
		
		model.addAttribute("image", i);
		
		//System.out.println("�̹��� ���� �Ϸ�");
		
		return "redirect:/";
		
		
	}	




}
