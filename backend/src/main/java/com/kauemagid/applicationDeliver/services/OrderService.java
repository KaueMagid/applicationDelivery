package com.kauemagid.applicationDeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kauemagid.applicationDeliver.dto.OrderDTO;
import com.kauemagid.applicationDeliver.dto.ProductDTO;
import com.kauemagid.applicationDeliver.entities.Order;
import com.kauemagid.applicationDeliver.entities.OrderStatus;
import com.kauemagid.applicationDeliver.entities.Product;
import com.kauemagid.applicationDeliver.repositories.OrderRepository;
import com.kauemagid.applicationDeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		//return list;
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto){
		 Order order = new Order(null, dto.getAddress(), 
				 dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
		 for(ProductDTO p : dto.getProducts()) {
			 Product product = productRepository.getOne(p.getId());
			 order.getProducts().add(product);
		 }
		 order = repository.save(order);
		 return new OrderDTO(order);
	}
}
