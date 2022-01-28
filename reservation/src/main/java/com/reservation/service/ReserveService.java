package com.reservation.service;

import java.util.List;


import com.reservation.dto.ReserveDto;

import com.reservation.entity.ReserveEntity;

public interface ReserveService {	
	public ReserveEntity insertReserve(ReserveDto reserveDto);
	
	public List<ReserveEntity> selectAll();
	
	public List<ReserveEntity> selectReserveByDate(String startDate, String endDate);
	
	public List<ReserveEntity> searchReserve(String startDate, String endDate);

	public List<ReserveDto> selectReserve();

	public List<ReserveDto> selectReserveDate(int no);

	
}
