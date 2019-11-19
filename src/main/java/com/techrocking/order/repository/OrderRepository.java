package com.techrocking.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techrocking.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query("SELECT MAX(o.id) FROM Order o")
	public Long getMaxId();

}
