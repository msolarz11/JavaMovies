package com.example.movies.adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class Converters {
    @BindingAdapter("app:posterUrl")
    public static void changeUrl(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);

    }
}
