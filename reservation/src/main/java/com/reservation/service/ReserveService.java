package com.reservation.service;

import java.util.List;


import com.reservation.dto.ReserveDto;

import com.reservation.entity.ReserveEntity;
import com.reservation.entity.RoomInfoEntity;

public interface ReserveService {	
	public ReserveEntity insertReserve(ReserveDto reserveDto);
	
	public List<ReserveEntity> selectAll();
	
	public List<ReserveEntity> selectReserveByDate(String startDate, String endDate);
	
	public List<ReserveEntity> searchReserve(String startDate, String endDate);

	//public List<ReserveDto> selectReserve();

	public List<Object[]> selectReserve();
	
	public List<ReserveEntity> selectReserveDate(int no);
	
	public ReserveDto updateReserve(ReserveDto dto);


	default ReserveDto dtoToEntity(ReserveEntity reserve) {
		return ReserveDto.builder()
				.name(reserve.getName())
				.phone(reserve.getPhone())
				.adult(reserve.getAdult())
				.child(reserve.getChild())
				.startDate(reserve.getStartDate())
				.endDate(reserve.getEndDate())
				.paymentFlg(reserve.getPaymentFlg())
				.totalcost(reserve.getTotalcost())
				.cancelFlg(reserve.getCancelFlg())
				.bankName(reserve.getBankName())
				.bankBranchCde(reserve.getBankBranchCde())
				.bankNo(reserve.getBankNo())
				.deleteFlg(reserve.getDeleteFlg())
				.roomNum(reserve.getRoomNum())
				.buildCd(2)
				.build();	
	}
	
	default ReserveEntity entityToDTO(ReserveDto dto) {
		return ReserveEntity.builder()
				.name(dto.getName())
				.phone(dto.getPhone())
				.adult(dto.getAdult())
				.child(dto.getChild())
				.startDate(dto.getStartDate())
				.endDate(dto.getEndDate())
				.paymentFlg(dto.getPaymentFlg())
				.totalcost(dto.getTotalcost())
				.cancelFlg(dto.getCancelFlg())
				.bankName(dto.getBankName())
				.bankBranchCde(dto.getBankBranchCde())
				.bankNo(dto.getBankNo())
				.deleteFlg(dto.getDeleteFlg())
				.roomNum(dto.getRoomNum())
				.buildCd(dto.getBuildCd())
				.build();	
	}
}
