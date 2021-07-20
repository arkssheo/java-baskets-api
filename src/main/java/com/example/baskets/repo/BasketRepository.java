package com.example.baskets.repo;

import com.example.baskets.dto.BasketDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<BasketDTO, Long> {
}
