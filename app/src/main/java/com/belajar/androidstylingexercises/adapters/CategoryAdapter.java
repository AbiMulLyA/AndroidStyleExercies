package com.belajar.androidstylingexercises.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.androidstylingexercises.R;
import com.belajar.androidstylingexercises.databinding.VerticalCategoryBinding;
import com.belajar.androidstylingexercises.models.CategoryModel;
import com.belajar.androidstylingexercises.models.ProductModel;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private ArrayList<CategoryModel> category = new ArrayList<>();
    Context context;

    public void setCategory(ArrayList<CategoryModel> category){
        Log.d("data", "response" + category);
        this.category = category;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VerticalCategoryBinding verticalCategoryBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.products_list,
                parent,
                false
        );
        return new MyViewHolder(verticalCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, int position) {
        holder.binData(category.get(position));
        holder.verticalCategoryBinding.getRoot().setOnClickListener(
                v -> onItemClickCallback.onItemClicked(category.get(holder.getAdapterPosition()))
        );
    }

    private CategoryAdapter.MyViewHolder.OnItemClickCallbackPost onItemClickCallback;
    public void setOnItemClickCallback(CategoryAdapter.MyViewHolder.OnItemClickCallbackPost onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        VerticalCategoryBinding verticalCategoryBinding;
        public MyViewHolder(@NonNull VerticalCategoryBinding binding) {
            super(binding.getRoot());
            this.verticalCategoryBinding = binding;
        }

        public void binData(CategoryModel categoryModel){
            verticalCategoryBinding.setCategory(categoryModel);
            verticalCategoryBinding.setImages(categoryModel.getImages());
        }

        public interface OnItemClickCallbackPost {
            void onItemClicked(CategoryModel data);
        }

    }
}
