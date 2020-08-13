package com.belajar.androidstylingexercises.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.belajar.androidstylingexercises.models.ProductModel;
import com.belajar.androidstylingexercises.repositories.ProductRepository;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsViewModel extends  BaseViewModel{
    private MutableLiveData<ArrayList<ProductModel>> products = new MutableLiveData<>();

    public void fetchProducts(){
        isLoading.setValue(true);
        ProductRepository postRepository = new ProductRepository();
        postRepository.service.getProducts().enqueue(new Callback<ArrayList<ProductModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductModel>> call, Response<ArrayList<ProductModel>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null && response.body().size() != 0) {
                        Log.d("result", "respoonse" + response.body());
                        products.setValue(response.body());
                    } else {
                        error.setValue("Data users kosong!");
                    }
                } else {
                    error.setValue(response.message());
                }

                isLoading.setValue(false);
            }

            @Override
            public void onFailure(Call<ArrayList<ProductModel>> call, Throwable t) {
                t.printStackTrace();
                Log.e("Error get posts", t.getMessage());

                error.setValue(t.getMessage());

                isLoading.setValue(false);
            }
        });
    }
    public MutableLiveData<ArrayList<ProductModel>> getProducts() {
        return products;
    }

    public void fetchCategory(){

    }
}
