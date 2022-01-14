package com.reservation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservation.entity.SliderimagesEntity;



@Repository
public interface SliderimagesRepository extends JpaRepository<SliderimagesEntity, Long> {
	



}
