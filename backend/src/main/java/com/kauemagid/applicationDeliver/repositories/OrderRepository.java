package com.kauemagid.applicationDeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kauemagid.applicationDeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

