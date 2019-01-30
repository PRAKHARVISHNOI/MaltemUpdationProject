package com.maltem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.maltem.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

	List<Message> findAllByTimestampLessThanEqualAndTimestampGreaterThanEqual(Long endDate, Long startDate);

}
