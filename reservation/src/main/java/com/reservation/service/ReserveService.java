package com.reservation.service;

import java.util.List;


import com.reservation.dto.ReserveDto;

import com.reservation.entity.ReserveEntity;

public interface ReserveService {	
	public ReserveEntity insertReserve(ReserveDto reserveDto);
}
