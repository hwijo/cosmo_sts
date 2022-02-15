package com.reservation.service;



import java.util.List;
import java.util.Optional;

import javax.persistence.EntityListeners;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.dto.ReserveDto;
import com.reservation.entity.ReserveEntity;
import com.reservation.entity.RoomInfoEntity;
import com.reservation.repository.ReserveRepository;


@Service
public class ReserveServiceImpl implements ReserveService {		
	
	@Autowired
	public ReserveRepository reserveRepository;
	
	
	/*
	 * public List<NoticeEntity> selectNotice() { return noticeRepository.findAll();
	 * }
	 * 
	 * 
	 * @Override public NoticeEntity selectByNo(int no) { return
	 * noticeRepository.findByNo(no); }
	 * 
	 */


    // 예약
	@Override
	public ReserveEntity insertReserve(ReserveDto reserveDto) {
		ReserveEntity reserveEntity = new ReserveEntity();
		ModelMapper modelMapper = new ModelMapper();
		reserveEntity = modelMapper.map(reserveDto, ReserveEntity.class);
		return reserveRepository.save(reserveEntity);
	}


	@Override
	public List<ReserveEntity> selectAll() {
		return reserveRepository.findAll();
	}



	@Override
	public List<ReserveEntity> selectReserveByDate(String startDate, String endDate) {
		return reserveRepository.selectReserveByDate(startDate, endDate);
	}


    @Transactional
	@Override
	public List<ReserveEntity> searchReserve(String startDate, String endDate) {
		return reserveRepository.findByStartDateLikeOrEndDateLike(startDate, endDate);

	}
    
	@Override
	public List<Object[]> selectReserve() {
		return reserveRepository.selectReserve();
/*		List<ReserveDto> reserveDtoList = new ArrayList<>();
		
		if(reserveEntities.isEmpty()) 
			return reserveDtoList;
		for(ReserveEntity reserve : reserveEntities) {
			reserveDtoList.add(this.convertEntityToDto(reserve));
		}
		
		return reserveDtoList;*/
	}

	
	@Override
	public List<ReserveEntity> selectReserveDate(int no) {
		return reserveRepository.selectReserveDate(no);
	}


	/*
	 * @Override public List<ReserveDto> searchReserve(String startDate) {
	 * List<ReserveEntity> reserveEntities =
	 * reserveRepository.findByStartDateLike(startDate); List<ReserveDto>
	 * reserveDtoList = new ArrayList<>();
	 * 
	 * if(reserveEntities.isEmpty()) return reserveDtoList; for(ReserveEntity
	 * reserve : reserveEntities) {
	 * reserveDtoList.add(this.convertEntityToDto(reserve)); }
	 * 
	 * return reserveDtoList; }
	 */

    // 전체 예약 리스트
/*	@Override
	public List<ReserveDto> selectReserve() {
		List<ReserveEntity> reserveEntities = reserveRepository.findAll();
		List<ReserveDto> reserveDtoList = new ArrayList<>();
		
		if(reserveEntities.isEmpty()) 
			return reserveDtoList;
		for(ReserveEntity reserve : reserveEntities) {
			reserveDtoList.add(this.convertEntityToDto(reserve));
		}
		
		return reserveDtoList;
	}
*/	

/*
	private ReserveDto convertEntityToDto(ReserveEntity reserve) {
		RoomInfoEntity roomInfo = new RoomInfoEntity(); 
    	return ReserveDto.builder()
				.name(reserve.getName())
				.phone(reserve.getPhone())
				.adult(reserve.getAdult())
				.child(reserve.getChild())
				.startDate(reserve.getStartDate())
				.endDate(reserve.getEndDate())
				.paymentFlg("0")
				.totalcost(reserve.getTotalcost())
				.cancelFlg("0")
				.bankName("신한")
				.bankBranchCde("01")
				.bankNo("01")
				.deleteFlg("0")
				.roomInfoEntity(RoomInfoEntity.builder().no(roomInfo.getNo()).build())
				.buildCd(2)		
				.build();	
        		
    }
*/

	@Override
	public ReserveDto updateReserve(ReserveDto dto) {
		ReserveEntity entity = reserveRepository.findById(dto.getNo()).get();
			
		System.out.println("서비스 entity : " + entity);
		//if(dto.getAdult() != null)
		//	entity.setAdult(dto.getAdult());
		//if(dto.getDeleteFlg() != null)
		//	entity.setDeleteFlg(dto.getDeleteFlg());
		//if(entity.getPaymentFlg() != null) {
		//	entity.setPaymentFlg("1");
		//	reserveRepository.save(entity);	
		//}		
		//reserveRepository.save(entity);
		
		reserveRepository.updateFlg(entity.getNo()); // paymentFlg 변경
		
		return entityToDto(entity);
	}


	



	











	
}

	
