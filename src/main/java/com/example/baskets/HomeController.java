package com.example.baskets;

import com.example.baskets.models.Basket;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class HomeController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/baskets/old", method = RequestMethod.GET)
    Basket[] basketList() {
        Basket[] baskets = {
                new Basket("coquis", "coquito"),
                new Basket("latte", "latete"),
                new Basket("grey", "greygrey")
        };
        return baskets;
    }


}
