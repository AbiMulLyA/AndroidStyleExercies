package com.belajar.androidstylingexercises;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.belajar.androidstylingexercises.adapters.ProductAdapter;
import com.belajar.androidstylingexercises.databinding.ActivityNorma2Binding;
import com.belajar.androidstylingexercises.viewmodels.ProductsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

public class Norma2Activity extends AppCompatActivity {
    ActivityNorma2Binding binding;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ProductAdapter adapter = new ProductAdapter();
        GridLayoutManager grid = new GridLayoutManager(this, 2);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_norma2);
        binding.rvProducts.setLayoutManager(grid);
        binding.rvProducts.setAdapter(adapter);
        ProductsViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ProductsViewModel.class);
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
