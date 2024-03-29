package com.springcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	public List<Request> findAllByOwnerId(Long id);
	
	@Query("UPDATE request SET state = ?2 WHERE id = ?1")
	public Request updateStatus(Long id, RequestStage state);
}