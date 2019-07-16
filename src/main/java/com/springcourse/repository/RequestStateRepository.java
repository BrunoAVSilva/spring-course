package com.springcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcourse.domain.RequestState;

@Repository
public interface RequestStateRepository extends JpaRepository<RequestState, Long> {

	public List<RequestState> findAllByRequestId(Long id);
}