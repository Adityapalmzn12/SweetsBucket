package com.adoredeveloper.sweetsbucket.Fragments;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.adoredeveloper.sweetsbucket.Adapters.TradingShopesAdapter;
import com.adoredeveloper.sweetsbucket.ApiInterface.ApiClient;
import com.adoredeveloper.sweetsbucket.ApiInterface.ApiInterface;
import com.adoredeveloper.sweetsbucket.Model.TradingShopes;


import com.adoredeveloper.sweetsbucket.R;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TradingShopesFragments extends Fragment {
    RecyclerView recyclerView;
    ApiInterface apiInterface;
    TradingShopesAdapter tradingShopesAdapter;
    List<TradingShopes.VendorDetails> shopesList=new ArrayList<TradingShopes.VendorDetails>();
    LinearLayoutManager linearLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Inflate the layout for this fragment */
        View view=inflater.inflate(R.layout.trading_shopes_fragments, container, false);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        recyclerView = view.findViewById(R.id.shopes_recycler_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        tradingShopesAdapter = new TradingShopesAdapter(shopesList, getContext());



        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(tradingShopesAdapter);
  getShopDetails();

        return view;
    }

    private void getShopDetails() {

              Call<List<TradingShopes>> listCall=apiInterface.shopesCall();
        final android.app.AlertDialog waitingDialog = new SpotsDialog(getContext());
        waitingDialog.show();
        waitingDialog.setMessage("Please wait");
        waitingDialog.setCancelable(false);

        listCall.enqueue(new Callback<List<TradingShopes>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @SuppressLint("Assert")
            @Override
            public void onResponse(@NonNull Call<List<TradingShopes>> call, @NonNull Response<List<TradingShopes>> response) {

                if (response.body()!=null) {
waitingDialog.dismiss();
                    ArrayList<TradingShopes> questionModels = (ArrayList<TradingShopes>) response.body();
//                    Toast.makeText(getContext(), response.toString(), Toast.LENGTH_LONG).show();


                    TradingShopes.VendorDetails  shopes1=null;
                    for (int i =0 ;i<questionModels.size();i++) {
                        shopes1=new TradingShopes.VendorDetails();
                          String storename1 = questionModels.get(i).vendorDetails.getStoreName();
                        String storeAddress = questionModels.get(i).vendorDetails.getAddress1();
                        String storeState = questionModels.get(i).vendorDetails.getState();
                        String storePin = questionModels.get(i).vendorDetails.getPin();
                        String image = questionModels.get(i).vendorDetails.getStoreFront();
                        shopes1.setStoreName(storename1);
                        shopes1.setAddress1(storeAddress);
                        shopes1.setState(storeState);
                        shopes1.setPin(storePin);
                        shopes1.setStoreFront(image);

                     shopesList.add(shopes1);
                    }
               }
                    tradingShopesAdapter.notifyDataSetChanged();
                }

            @Override
            public void onFailure(Call<List<TradingShopes>> call, Throwable t) {

            }



        });

    }


}