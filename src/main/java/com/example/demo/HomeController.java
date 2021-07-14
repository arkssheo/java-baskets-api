package com.example.demo;

import com.example.demo.models.Basket;
import com.example.demo.models.GenericObjectResponse;
import org.apache.coyote.Response;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class HomeController {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/basket/{id}")
    ResponseEntity<GenericObjectResponse<Basket>> basket(@PathVariable("id") int id) {
        if (id == 1) {
            Basket basket = new Basket("test", "coquito");
            GenericObjectResponse<Basket> basketResponse = new GenericObjectResponse<>(200);
            basketResponse.setResponseObject(basket);
            basketResponse.setMoreInfo("coquito es bello");
            return ResponseEntity.ok(basketResponse);
        } else {
            GenericObjectResponse<Basket> basketResponse = new GenericObjectResponse<>(404);
            basketResponse.setMoreInfo("item not found");
            return ResponseEntity.status(404).body(basketResponse);
        }

    }

    @RequestMapping(value = "/baskets", method = RequestMethod.GET)
    Basket[] basketList() {
        Basket[] baskets = {
                new Basket("coquis", "coquito"),
                new Basket("latte", "latete"),
                new Basket("grey", "greygrey")
        };
        return baskets;
    }
}
