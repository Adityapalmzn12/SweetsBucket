package com.adoredeveloper.sweetsbucket.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.adoredeveloper.sweetsbucket.ApiInterface.ApiClient;
import com.adoredeveloper.sweetsbucket.ApiInterface.ApiInterface;
import com.adoredeveloper.sweetsbucket.Fragments.Cart;
import com.adoredeveloper.sweetsbucket.Fragments.HomeCategoryFragment;
import com.adoredeveloper.sweetsbucket.Model.HomeShopsAll;
import com.adoredeveloper.sweetsbucket.R;
import com.daimajia.slider.library.SliderLayout;
import com.rey.material.app.Dialog;
import com.rey.material.widget.RelativeLayout;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeShoapAdapter extends RecyclerView.Adapter<HomeShoapAdapter.ViewHolder> {
    private List<HomeShopsAll.VendorDetails> shoapAllDetails;
    private Context context;

  public  String url="http://www.sweetsbucket.com/";
  public HomeShoapAdapter(List<HomeShopsAll.VendorDetails> shoapAllDetails, Context context) {
        this.shoapAllDetails=shoapAllDetails;
        this.context=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_shoap_adapter, parent, false);
ViewHolder viewHolder=new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


        holder.sweetNames.setText(shoapAllDetails.get(position).getStoreName());
        Picasso.with(context).load(url+shoapAllDetails.get(position).storeFront).into(holder.menu_image);
      //  holder.food_description.setText(shoapAllDetails.get(position).getDescription());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("Image", shoapAllDetails.get(position).getStoreFront());
                bundle.putString("FoodName", shoapAllDetails.get(position).getStoreName());
                bundle.putString("Description", shoapAllDetails.get(position).getDescription());
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment myFragment = new Cart();
                myFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, myFragment).addToBackStack(null).commit();
                Toast.makeText(context,shoapAllDetails.get(position).getStoreName(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount(){
  return shoapAllDetails.size();

        }
   public class ViewHolder  extends RecyclerView.ViewHolder {

    TextView sweetNames,food_description,shp_state ,shp_Address1;
    SliderLayout slider;
    CardView cardview;

        ImageView menu_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.sweetNames = itemView.findViewById(R.id.sweetNames);
            this.menu_image=itemView.findViewById(R.id.menu_image);
          //  this.food_description = itemView.findViewById(R.id.food_description);
            this.cardview=itemView.findViewById(R.id.cardview);

        }
    }
}
