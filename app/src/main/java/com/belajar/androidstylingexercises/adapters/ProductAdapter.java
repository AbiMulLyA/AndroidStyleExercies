package com.belajar.androidstylingexercises.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.androidstylingexercises.R;
import com.belajar.androidstylingexercises.databinding.ItemBinding;
import com.belajar.androidstylingexercises.models.ProductModel;
import com.belajar.androidstylingexercises.viewmodels.ProductsViewModel;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    private ArrayList<ProductModel> products = new ArrayList<>();
    public void setProducts(ArrayList<ProductModel> products){
        Log.d("data", "response" + products);
        this.products = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item,
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        holder.bindData(products.get(position));
    }

    @Override
    public int getItemCount() {
        if (products != null){
            return products.size();
        }else{
            return 0;
        }
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        ItemBinding binding;

        public ViewHolder(@NonNull ItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(ProductModel productModel){
            binding.setProducts(productModel);
            binding.setImage(productModel.getImage());
        }
    }
}
