package com.belajar.androidstylingexercises.repositories;

import com.belajar.androidstylingexercises.models.ProductModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("products")
    Call<ArrayList<ProductModel>> getProducts();
}
