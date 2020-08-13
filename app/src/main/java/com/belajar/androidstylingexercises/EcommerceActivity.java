package com.belajar.androidstylingexercises;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.androidstylingexercises.adapters.CategoryAdapter;
import com.belajar.androidstylingexercises.adapters.ProductAdapter;
import com.belajar.androidstylingexercises.databinding.ActivityNorma2Binding;
import com.belajar.androidstylingexercises.databinding.ProductsListBinding;
import com.belajar.androidstylingexercises.models.CategoryModel;
import com.belajar.androidstylingexercises.viewmodels.CategoryViewModels;
import com.belajar.androidstylingexercises.viewmodels.ProductsViewModel;
import java.util.ArrayList;

public class EcommerceActivity extends AppCompatActivity{
    ProductsListBinding binding;
    CategoryAdapter adapter = new CategoryAdapter();
    GridLayoutManager grid = new GridLayoutManager(this, 2);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_norma2);
        binding.rvProducts.setLayoutManager(grid);
        binding.rvProducts.setAdapter(adapter);
    CategoryViewModels viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ProductsViewModel.class);
        viewModel.getProducts().observe(this, adapter::setProducts);
        viewModel.fetchProducts();
        viewModel.getIsLoading().observe(this, isLoading -> {
        binding.pbLoadingProducts.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        binding.rvProducts.setVisibility(isLoading ? View.GONE : View.VISIBLE);
    });

        viewModel.getError().observe(this, error -> {
        if (!TextUtils.isEmpty(error)) {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    });
        binding.setViewModel(viewModel);
}
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
