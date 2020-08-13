package com.belajar.androidstylingexercises.repositories;

import com.belajar.androidstylingexercises.utils.ClientUtil;

public class ProductRepository {
    private static final String BASE_URL = "https://fakestoreapi.com/";

    public ProductService service;

    public ProductRepository() {
        service = ClientUtil.client(ProductService.class, BASE_URL);
    }
}
