package com.adoredeveloper.sweetsbucket.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridLayout;
import android.widget.Toast;

import com.adoredeveloper.sweetsbucket.Adapters.HomeShoapAdapter;
import com.adoredeveloper.sweetsbucket.ApiInterface.ApiClient;
import com.adoredeveloper.sweetsbucket.ApiInterface.ApiInterface;
import com.adoredeveloper.sweetsbucket.Model.HomeShopsAll;
import com.adoredeveloper.sweetsbucket.R;
import com.daimajia.slider.library.SliderLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeShops extends Fragment {
ApiInterface apiInterface;
HomeShoapAdapter homeShoapAdapter;
    List<HomeShopsAll.VendorDetails> shoapAllDetails=new ArrayList<HomeShopsAll.VendorDetails>();
    LinearLayoutManager linearLayoutManager;
RecyclerView recyclerView;
    HashMap<String,String> image_list;
    SliderLayout mSlider;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view=inflater.inflate(R.layout.fragment_home_shops, container, false);
        mSlider=(SliderLayout)view.findViewById(R.id.slider);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        recyclerView = view.findViewById(R.id.shoap_recycler_view);

//        linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(GridLayout.VERTICAL);
        homeShoapAdapter = new HomeShoapAdapter(shoapAllDetails,getContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
//        LayoutAnimationController controller= AnimationUtils.loadLayoutAnimation(recyclerView.getContext(),R.anim.l)
      recyclerView.setAdapter(homeShoapAdapter);

        getAllShoaps();

        return view;
    }




    private void getAllShoaps() {
        Call<List<HomeShopsAll>>listCallShoap=apiInterface.shopsAllCall();
        final android.app.AlertDialog waitingDialog = new SpotsDialog(getContext());
        waitingDialog.show();
        waitingDialog.setMessage("Please wait");
        waitingDialog.setCancelable(false);
        listCallShoap.enqueue(new Callback<List<HomeShopsAll>>() {
            @Override
            public void onResponse(Call<List<HomeShopsAll>> call, Response<List<HomeShopsAll>> response) {
                if (response!=null){
                      waitingDialog.dismiss();
                   ArrayList<HomeShopsAll> questionModels = (ArrayList<HomeShopsAll>) response.body();
//                    Toast.makeText(getContext(), response.toString(), Toast.LENGTH_LONG).show();


                    HomeShopsAll.VendorDetails  shopes2=null;
                    for (int i =0 ;i<questionModels.size();i++) {
                        shopes2=new HomeShopsAll.VendorDetails();
                        String storename1 = questionModels.get(i).vendorDetails.getStoreName();
                    //    String storedescription = questionModels.get(i).vendorDetails.getDescription();
                  //  String shpAddress1 = questionModels.get(i).vendorDetails.getAddress1();
//                        String storePin = questionModels.get(i).vendorDetails.getPin();
                       String image = questionModels.get(i).vendorDetails.getStoreFront();
                        shopes2.setStoreName(storename1);

                 //       shopes2.setAddress1(storedescription);
             //       shopes2.setAddress1(shpAddress1);
//                        shopes2.setPin(storePin);
                       shopes2.setStoreFront(image);

                        shoapAllDetails.add(shopes2);
                    }
                }
                homeShoapAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<HomeShopsAll>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }

}
