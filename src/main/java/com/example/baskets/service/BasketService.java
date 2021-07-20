package com.example.baskets.service;

import com.example.baskets.dto.BasketDTO;
import com.example.baskets.repo.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService implements IBasketService {

    @Autowired
    private BasketRepository repository;

    @Override
    public List<BasketDTO> findAll() {
        return (List<BasketDTO>) repository.findAll();
    }

    @Override
    public BasketDTO find(Long id) throws ChangeSetPersister.NotFoundException {
        return repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public BasketDTO save(BasketDTO basket) {
        return repository.save(basket);
    }


}
