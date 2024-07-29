package com.example.productservicettsevening;


import com.example.productservicettsevening.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class FunctionalTest {
   /* @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllProducts() throws Exception{
        mockMvc.perform(
                get("/products")
        )
                .andExpect(status().is(200))
                .andExpect(header().exists("authorization"))
                .andExpect(content().string("{}"));

    }*/
}
