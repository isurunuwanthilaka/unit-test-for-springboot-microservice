package com.isumalab.unittesting.controller;

import com.isumalab.unittesting.model.Item;
import com.isumalab.unittesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;


    @GetMapping("/dummy-item")
    public Item getItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/business-item")
    public Item getItemFromBusinessService() {
        return businessService.getItem();
    }

    @GetMapping("/all-item")
    public List<Item> getAllItems() {
        return businessService.retrieveAllItems();
    }
}
