package com.reservation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservation.entity.ReserveEntity;


@Repository
public interface ReserveRepository extends JpaRepository<ReserveEntity, Long> {

	//NoticeEntity findByNo(int no);


}
