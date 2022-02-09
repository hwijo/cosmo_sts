package com.reservation.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.reservation.dto.ConsultationDto;
import com.reservation.dto.ReserveDto;
import com.reservation.entity.ConsultationEntity;
import com.reservation.entity.ReserveEntity;
import com.reservation.entity.RoomInfoEntity;
import com.reservation.repository.ConsultationRepository;



@Service
public class ConsultationServiceImpl implements ConsultationService {		
	
	@Autowired
	public ConsultationRepository consultationRepository;
	

	

	@Override
	public ConsultationEntity insertConsultation(ConsultationDto consultationDto) {
		ConsultationEntity consultationEntity = new ConsultationEntity();
		ModelMapper modelMapper = new ModelMapper();
		consultationEntity = modelMapper.map(consultationDto, ConsultationEntity.class);
		return consultationRepository.save(consultationEntity);
	}



	@Override
	public ConsultationEntity selectByNo(int no) {
		return consultationRepository.findByNo(no);
	}

    // 상담 등록
	@Override
	public int insertReply(ConsultationDto consultationDto) {
		ConsultationEntity consultationEntity = new ConsultationEntity();
		ModelMapper modelMapper = new ModelMapper();
		consultationEntity = modelMapper.map(consultationDto, ConsultationEntity.class);
		ConsultationEntity entity = consultationRepository.save(consultationEntity);
		
		System.out.println(entity);
		
		int grno = entity.getNo();
		
		System.out.println(grno);
		
		return consultationRepository.updateReply(grno);
		 
	}




	// 원글, 답글, 답글의 답글 등 순서대로 출력
	@Override
	public List<ConsultationEntity> selectConsultation() {
		return consultationRepository.selectConsultationList();
	}

/*	
	@Override
	public Long savePost(ConsultationDto dto) {
		Optional<ConsultationEntity> onec = consultationRepository.findByGrno((long)dto.getGrno());
		if(onec.isPresent()) {
			ConsultationEntity c1 = onec.get(); // 부모
			int grno = c1.getGrno();
			int grgrod = c1.getGrgrod();
			int depth = c1.getDepth();
			
			String result = consultationRepository.equalOrder(grno, grgrod, depth);
			System.out.println("-------------------------------------------------1");
			System.out.println(result);
			System.out.println("-------------------------------------------------1");
			
			if(result == null) { // 
				int xy = consultationRepository.resultOrder(grno);
				System.out.println("-------------------------------------------------2");
				System.out.println(xy);
				System.out.println("-------------------------------------------------2");
				dto.setGrno(grno);
				dto.setGrgrod(grgrod);				
			}
			else {
				System.out.println("-------------------------------------------------3");
				System.out.println(result);
				System.out.println("-------------------------------------------------3");
			    int yz = Integer.parseInt(result);
			    dto.setGrno(grno);
			    dto.setGrgrod(yz);
			    consultationRepository.updateOrder(grno, grgrod, yz);
			}
			//ConsultationEntity consultation = dto.toEntity();
			ConsultationEntity consultation = convertDtotoEntity(dto);
			consultationRepository.save(consultation);
			
			
		}
		
	}
	
*/	
	private ConsultationEntity convertDtotoEntity(ConsultationDto dto) {
		//RoomInfoEntity roomInfo = new RoomInfoEntity(); 
    	return ConsultationEntity.builder()
    			.grno(dto.getGrno())
				.grgrod(dto.getGrgrod())
				.depth(dto.getDepth())
				.title(dto.getTitle())
				.contents(dto.getContents())
				.name(dto.getName())
				.passwd(dto.getPasswd())
				.build();	
        		
    }







	
}

	
