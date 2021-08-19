package com.koreait.day2.repository;

import com.koreait.day2.model.entity.OrderGroup;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderGroupRepository extends JpaRepository<OrderGroup, Long> {

    Optional<OrderGroup> findByRevName(String revName);
}
