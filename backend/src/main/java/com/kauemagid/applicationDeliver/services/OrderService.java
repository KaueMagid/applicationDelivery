package com.kauemagid.applicationDeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kauemagid.applicationDeliver.dto.OrderDTO;
import com.kauemagid.applicationDeliver.entities.Order;
import com.kauemagid.applicationDeliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		//return list;
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
}
