package com.example.baskets.controller;

import com.example.baskets.dto.BasketDTO;
import com.example.baskets.service.IBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class BasketController {

    @Autowired
    private IBasketService basketService;

    @RequestMapping(value = "/baskets", method = RequestMethod.GET)
    ResponseEntity<List<BasketDTO>> findBaskets() {
        List<BasketDTO> baskets = basketService.findAll();
        return ResponseEntity.ok(baskets);
    }

    @RequestMapping("/basket/{id}")
    ResponseEntity<BasketDTO> basket(@PathVariable("id") Long id) {
        try {
            BasketDTO basket = basketService.find(id);
            return ResponseEntity.ok(basket);
        } catch (ChangeSetPersister.NotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/basket", method = RequestMethod.POST)
    ResponseEntity addBasket(@RequestBody BasketDTO newBasket) {
        basketService.save(newBasket);
        return ResponseEntity.ok(null);
    }
}
