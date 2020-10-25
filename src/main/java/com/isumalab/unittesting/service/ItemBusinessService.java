package com.isumalab.unittesting.service;

import com.isumalab.unittesting.data.ItemRepository;
import com.isumalab.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {
    @Autowired
    private ItemRepository repository;

    public Item getItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> lst = getAll();
        lst.forEach(t -> t.setValue(t.getPrice() * getValue()));
        return lst;
    }

    private int getValue(){
        return 5;
    }

    private List<Item> getAll(){
        return repository.findAll();
    }
}
