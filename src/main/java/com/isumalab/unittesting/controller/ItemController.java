package com.isumalab.unittesting.controller;

import com.isumalab.unittesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item getItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
