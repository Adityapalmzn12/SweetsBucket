package com.adoredeveloper.sweetsbucket.Fragments;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.adoredeveloper.sweetsbucket.R;
import com.andremion.counterfab.CounterFab;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import com.stepstone.apprating.AppRatingDialog;

import java.util.Arrays;
import java.util.Objects;

import info.hoang8f.widget.FButton;


public class Cart extends Fragment {
ImageView img_food,priceImage;
CounterFab btnCart;
FloatingActionButton btn_rating;
TextView food_name,food_description,food_discount_price,food_price;
FButton btnShowComment;
RatingBar ratingBar;
ElegantNumberButton number_button;
    public  String url="http://www.sweetsbucket.com/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        img_food = view.findViewById(R.id.img_food);
        priceImage = view.findViewById(R.id.priceImage);
        btnCart = view.findViewById(R.id.btnCart);
        food_name = view.findViewById(R.id.food_name);
        food_discount_price = view.findViewById(R.id.food_discount_price);
        food_price = view.findViewById(R.id.food_price);
        food_description = view.findViewById(R.id.food_description);
        btnShowComment = view.findViewById(R.id.btnShowComment);
        ratingBar = view.findViewById(R.id.ratingBar);
        number_button = view.findViewById(R.id.number_button);
        btn_rating = view.findViewById(R.id.btn_rating);
        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRatingDialog();
            }
        });
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String image = bundle.get("Image").toString();
            String storeName = bundle.get("FoodName").toString();
           // String description = bundle.get("Description").toString();
            Picasso.with(getActivity()).load(url+image).into(img_food);
            food_name.setText(storeName);
         //   food_description.setText(description);
        }
         return view;
        }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void showRatingDialog() {

        new AppRatingDialog.Builder()
                .setPositiveButtonText("Submit")
                .setNegativeButtonText("Cancel")
                .setNoteDescriptions(Arrays.asList("Very Bad","Not Good","Quite OK","Very Good","Awesome Taste"))
                .setDefaultRating(1)
                .setTitle("Rate this Food")
                .setDescription("Please Select Some Stars and Give Your FeedBack")
                .setTitleTextColor(R.color.colorPrimary)
                .setDescriptionTextColor(R.color.colorPrimary)
                .setHint("Please Write Your FeedBack Here")
                .setHintTextColor(R.color.colorAccent)
                .setCommentTextColor(android.R.color.white)
                .setCommentBackgroundColor(R.color.colorPrimaryDark)
                .setWindowAnimation(R.style.RatingDialogFadeAnim)
                .create(Objects.requireNonNull(getActivity()))
                .show();

    }

}

