package com.adoredeveloper.sweetsbucket.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.adoredeveloper.sweetsbucket.ApiInterface.ApiClient;
import com.adoredeveloper.sweetsbucket.ApiInterface.ApiInterface;
import com.adoredeveloper.sweetsbucket.Adapters.HomeCategoryAdapter;
import com.adoredeveloper.sweetsbucket.Model.HomeCategorySweets;
import com.adoredeveloper.sweetsbucket.R;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeCategoryFragment extends Fragment {
    RecyclerView recyclerView;
    ApiInterface apiInterface;
    HomeCategoryAdapter homeCategoryAdapter;
    List<HomeCategorySweets> homeCategorySweetsList=new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_category, container, false);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        recyclerView = view.findViewById(R.id.my_recycler_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homeCategoryAdapter = new HomeCategoryAdapter(homeCategorySweetsList, getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(homeCategoryAdapter);

        getAllSweets();

        return view;
    }

    private void getAllSweets() {
        final Call<List<HomeCategorySweets>> listCall=apiInterface.SweetsCall();
        final android.app.AlertDialog waitingDialog = new SpotsDialog(getContext());
        waitingDialog.show();
        waitingDialog.setMessage("Please wait");
        waitingDialog.setCancelable(false);
        listCall.enqueue(new Callback<List<HomeCategorySweets>>() {
            @Override
            public void onResponse(Call<List<HomeCategorySweets>> call, Response<List<HomeCategorySweets>> response) {

                if (response.body()!=null) {
                    waitingDialog.dismiss();
                      List<HomeCategorySweets> homeCategorySweets = response.body();


                    HomeCategorySweets homeCategorySweets1=null;
                    for (int i =0 ;i<homeCategorySweets.size();i++) {
                        homeCategorySweets1 = new HomeCategorySweets();

                        String name = homeCategorySweets.get(i).getName();

//                        String price = homeCategorySweets.get(i).getPrice();
//                        homeCategorySweets1.setId(id);
                        homeCategorySweets1.setName(name);
//                        homeCategorySweets1.setProductname(name);
//                        homeCategorySweets1.setImageurl(image);
                        homeCategorySweetsList.add(homeCategorySweets1);


                    }

                    }
        homeCategoryAdapter.notifyDataSetChanged();


                }



            @Override
            public void onFailure(@NonNull Call<List<HomeCategorySweets>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();

            }
        });

    }


}
