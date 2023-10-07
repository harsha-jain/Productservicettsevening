package com.example.productservicettsevening.Clients.FakeStoreApi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
        private long id;
        private String title;
        private double price;
        private String description;
        private String image;
        private String Category;

}
