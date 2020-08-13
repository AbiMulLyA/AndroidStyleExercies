package com.belajar.androidstylingexercises.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.belajar.androidstylingexercises.models.CategoryModel;

import java.util.ArrayList;

public class CategoryViewModels extends ViewModel {
    MutableLiveData<ArrayList<CategoryModel>> categoryModel;
    private ArrayList<CategoryModel> categoryModelList;

    public CategoryViewModels(){
        categoryModel = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<CategoryModel>> getCategoryList(){
        return categoryModel;
    }

    private void init() {
        categoryModelList = new ArrayList<>();
        categoryModelList.add(
                new CategoryModel("men clothing",
                        "https://i.pinimg.com/originals/8b/42/03/8b4203bc89605c3348eed9e15f89e574.jpg"));
        categoryModelList.add(
                new CategoryModel("jewelery",
                        "https://image.freepik.com/free-photo/ripple-ornament-forever-drop-costume_1232-3547.jpg"));
        categoryModelList.add(
                new CategoryModel("electronics",
                        "https://static.republika.co.id/uploads/images/inpicture_slide/international-consumer-electronics-show-ces-di-las-vegas_200729131322-539.jpg"));
        categoryModelList.add(
                new CategoryModel("women clothing",
                        "https://fakestoreapi.com/img/61pHAEJ4NML._AC_UX679_.jpg"));

        categoryModel.setValue(categoryModelList);

    }
}
