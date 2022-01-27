package com.reservation.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reservation.dto.NoticeDto;
import com.reservation.dto.ReserveDto;
import com.reservation.dto.ReserveDto.ReserveDtoBuilder;
import com.reservation.entity.NoticeEntity;
import com.reservation.entity.ReserveEntity;
import com.reservation.entity.RoomInfoEntity;
import com.reservation.repository.NoticeRepository;
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
    
/*    
    private ReserveDto convertEntityToDto(ReserveEntity reserve) {
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
				.buildCd(2)		
				.build();	
        		
    }
*/





	
}

	
