package com.reservation.service;



import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.dto.ConsultationDto;
import com.reservation.entity.ConsultationEntity;
import com.reservation.repository.ConsultationRepository;



@Service
public class ConsultationServiceImpl implements ConsultationService {		
	
	@Autowired
	public ConsultationRepository consultationRepository;
	

	

	@Override
	public ConsultationEntity insertConsultation(ConsultationDto consultationDto) {
		ConsultationEntity consultationEntity = dtoToEntity(consultationDto);
		return consultationRepository.save(consultationEntity);
	}



	@Override
	public ConsultationEntity selectByNo(int no) {
		return consultationRepository.findByNo(no);
	}

    // 상담, 답글 등록
	@Transactional
	@Override
	public int insertReply(ConsultationDto consultationDto) {
		ConsultationEntity consultationEntity = dtoToEntity(consultationDto);
		System.out.println("insertReply: "+consultationDto);
		if(0 == consultationDto.getGrno()) { // 원글
			Function<ConsultationEntity, ConsultationDto> fn = (entity -> entityToDTO(entity));
			
			ConsultationEntity entity = consultationRepository.save(consultationEntity);
			System.out.println(entity);
			
			int grno = entity.getNo();
			
			System.out.println(grno);
			
			return consultationRepository.updateReply(grno);
		} else { // 답글
			consultationRepository.updateReplyGrgrod(consultationDto.getGrgrod());
			System.out.println("insertReplyEntity: "+consultationEntity.toString());
			ConsultationEntity entity = consultationRepository.save(consultationEntity);
			return entity.getNo(); 
		}
		
		
		
		 
	}


	// 원글, 답글, 답글의 답글 등 순서대로 출력
	@Override
	public List<ConsultationDto> selectConsultation() {
		Function<ConsultationEntity, ConsultationDto> fn = (entity -> entityToDTO(entity));
		List<ConsultationEntity> entity = consultationRepository.selectConsultationList();
		List<ConsultationDto> result = entity.stream().map(fn).collect(Collectors.toList());
		return result;
	}
	
	/*
	 * @Override public int selectConsultationListGrno(int grno) {
	 * List<ConsultationEntity> list =
	 * consultationRepository.selectConsultationListGrno(grno); int maxGrgrod = 0;
	 * for(int i=0;i<list.size();i++) { if(list.get(i).getGrgrod() ==
	 * consultationRepository.selectMaxGrno(grno)) { maxGrgrod =
	 * list.get(i).getGrgrod();
	 * 
	 * }
	 * 
	 * } return maxGrgrod;
	 * 
	 * 
	 * }
	 * 
	 */
	
	

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

	
