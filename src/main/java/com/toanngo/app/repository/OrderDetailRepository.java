package com.toanngo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.toanngo.app.models.DetailOrder;

@Repository
@Component
public interface OrderDetailRepository extends JpaRepository<DetailOrder, Integer>{

}
