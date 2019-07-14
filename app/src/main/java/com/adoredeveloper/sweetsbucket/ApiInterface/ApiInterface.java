package com.adoredeveloper.sweetsbucket.ApiInterface;



import com.adoredeveloper.sweetsbucket.Model.HomeCategorySweets;
import com.adoredeveloper.sweetsbucket.Model.LoginModel;
import com.adoredeveloper.sweetsbucket.Model.HomeShopsAll;
import com.adoredeveloper.sweetsbucket.Model.TradingShopes;
import com.adoredeveloper.sweetsbucket.Model.SignUpModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ApiInterface {
    @FormUrlEncoded
    @Headers("X-Requested-With:XMLHttpRequest")
    @POST("/api/apiRegister")

//register user
    Call<SignUpModel> createUser(@Field("name") String name, @Field("email") String email, @Field("mobile") String mobile, @Field("password") String password, @Field("password_confirmation") String password_confirmation);
    //login user
    @FormUrlEncoded
    @Headers("X-Requested-With:XMLHttpRequest")
    @POST("/api/apiLogin")
    Call<LoginModel>loginUser(@Field("login") String login, @Field("password") String password);
//
@Headers("X-Requested-With:XMLHttpRequest")
    @GET("/api/category")
Call <List<HomeCategorySweets>>SweetsCall ();


    @Headers("X-Requested-With:XMLHttpRequest")
    @GET("/api/trandingShops")
    Call <List<TradingShopes>>shopesCall();
    @Headers("X-Requested-With:XMLHttpRequest")
    @GET("/api/shops")
    Call <List<HomeShopsAll>>shopsAllCall();
}
