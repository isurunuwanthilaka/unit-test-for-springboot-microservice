package com.isumalab.unittesting.controller;

import com.isumalab.unittesting.model.Item;
import com.isumalab.unittesting.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    void getItem() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10}"))
                .andReturn();

    }

    @Test
    void getItemFromBusinessService() throws Exception {

        when(businessService.getItem()).thenReturn(new Item(1, "Ball", 10, 100));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/business-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10}"))
                .andReturn();
    }

    @Test
    void getAllItems_basics() throws Exception {

        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new Item(1, "Ball", 10, 100),
                        new Item(2, "Ball", 10, 100),
                        new Item(3, "Ball", 10, 100)
                ));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Ball\",\"price\":10}," +
                        "{\"id\":2,\"name\":\"Ball\",\"price\":10}," +
                        "{\"id\":3,\"name\":\"Ball\",\"price\":10}]"))
                .andReturn();
    }
}