package com.belajar.androidstylingexercises.models;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

public class CategoryModel{
    @SerializedName("category")
    private String category;

    @SerializedName("image")
    private String images;

    public CategoryModel(String category, String images) {
        this.category = category;
        this.images = images;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @BindingAdapter("images")
    public static void loadImage(ImageView view, String images){
        Glide.with(view.getContext()).load(images).apply(RequestOptions.centerInsideTransform()).into(view);
    }
}
