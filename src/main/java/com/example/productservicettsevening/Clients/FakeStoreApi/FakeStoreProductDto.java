package com.example.productservicettsevening.Clients.FakeStoreApi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class FakeStoreProductDto implements Serializable {
        private long id;
        private String title;
        private double price;
        private String description;
        private String image;
        private String Category;

}
