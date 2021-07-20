package com.example.baskets.service;

import com.example.baskets.dto.BasketDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IBasketService {
    List<BasketDTO> findAll();
    BasketDTO find(Long id) throws ChangeSetPersister.NotFoundException;
    BasketDTO save(BasketDTO basket);
}
