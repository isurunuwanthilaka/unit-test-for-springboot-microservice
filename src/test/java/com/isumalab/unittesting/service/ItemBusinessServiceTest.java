package com.isumalab.unittesting.service;

import com.isumalab.unittesting.data.ItemRepository;
import com.isumalab.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business;

    @Mock
    private ItemRepository repository;

    @Test
    void getItem() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Item(1, "Ball", 10, 100),
                new Item(2, "Ball", 10, 100),
                new Item(3, "Ball", 10, 100)
        ));
        List<Item> items = business.retrieveAllItems();

        assertEquals(items.get(0).getValue(),50);
        assertEquals(items.get(1).getValue(),50);
        assertEquals(items.get(2).getValue(),50);
    }
}