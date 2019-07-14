package com.adoredeveloper.sweetsbucket.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adoredeveloper.sweetsbucket.Model.TradingShopes;
import com.adoredeveloper.sweetsbucket.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TradingShopesAdapter extends RecyclerView.Adapter<TradingShopesAdapter.ViewHolder> {
    private List<TradingShopes.VendorDetails> shopesList;
     private Context context;
    public  String url="http://www.sweetsbucket.com/";
    public TradingShopesAdapter(List<TradingShopes.VendorDetails> shopesList, Context context) {
        this.shopesList = shopesList;
    this.context = context;
    }




    @NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_trading_shopes_adapter, parent, false);
        return new TradingShopesAdapter.ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.shop_name.setText(shopesList.get(position).getStoreName());
    holder.shp_location.setText(shopesList.get(position).getAddress1());
    holder.shp_state.setText(shopesList.get(position).getState());
    holder.shp_pin.setText(shopesList.get(position).getPin());
    //Picasso.with(context).load(shopesList.get(position).getStoreFront()).resize(50, 50).
     //       centerCrop().into(holder.shop_image);
//    holder.shop_name.setText(shopesList.get(position));
    Picasso.with(context).load(url+shopesList.get(position).getStoreFront()).into(holder.shop_image);



        }

@Override
public int getItemCount() {

        return shopesList.size();
        }

class ViewHolder  extends RecyclerView.ViewHolder {
    TextView shop_name,shp_location,shp_state ,shp_pin;
    ImageView shop_image;
    ViewHolder(View itemView) {
        super(itemView);
        this.shop_name = itemView.findViewById(R.id.shop_name);
       this.shop_image=itemView.findViewById(R.id.shop_image);
        this.shp_location=itemView.findViewById(R.id.shp_location);
        this.shp_state=itemView.findViewById(R.id.shp_state);
        this.shp_pin=itemView.findViewById(R.id.shp_pin);


    }
}




    }

