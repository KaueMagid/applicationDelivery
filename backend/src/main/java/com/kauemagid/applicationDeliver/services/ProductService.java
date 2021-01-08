package com.kauemagid.applicationDeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kauemagid.applicationDeliver.dto.ProductDTO;
import com.kauemagid.applicationDeliver.entities.Product;
import com.kauemagid.applicationDeliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAllByOrderByNameAsc();
		//return list;
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
}
