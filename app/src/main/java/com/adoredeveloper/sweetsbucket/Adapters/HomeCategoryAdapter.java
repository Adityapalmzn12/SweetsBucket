package com.adoredeveloper.sweetsbucket.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adoredeveloper.sweetsbucket.Model.HomeCategorySweets;
import com.adoredeveloper.sweetsbucket.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder> {
        public List<HomeCategorySweets> homeCategorySweetsList;
        public Context context;
    public  String url="http://www.sweetsbucket.com/";


    public HomeCategoryAdapter(List<HomeCategorySweets> homeCategorySweetsList, Context context) {
        this.homeCategorySweetsList = homeCategorySweetsList;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_category_adapter, parent, false);
        return new HomeCategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.store_Name.setText(homeCategorySweetsList.get(position).getName());
       // Picasso.with(context).load(url+homeCategorySweetsList.get(position).).into(holder.imageView_menuImage);
       // holder.shp_location.setText(homeCategorySweetsList.get(position));
//        holder.tvSchSlotTime.setText(drScheduleModelArrayList.get(position).getSlot_time());
//        holder.tvsch_duration.setText(drScheduleModelArrayList.get(position).getDuration());
//        holder.tvschStarttime.setText(drScheduleModelArrayList.get(position).getStarttime());
//        holder.tvSchendtime.setText(drScheduleModelArrayList.get(position).getEndtime());
    }

    @Override
    public int getItemCount() {

        return homeCategorySweetsList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {
        TextView store_Name,shp_location ;
ImageView imageView_menuImage;

        public ViewHolder(View itemView) {
            super(itemView);
            store_Name = itemView.findViewById(R.id.store_Name);
            shp_location = itemView.findViewById(R.id.shp_location);
       //     imageView_menuImage = itemView.findViewById(R.id.imageView_menuImage);

//            tvSchSlotTime = itemView.findViewById(R.id.sch_slot_time);
//            tvsch_duration = itemView.findViewById(R.id.sch_duration);
//            tvschStarttime = itemView.findViewById(R.id.sch_start_time);
//            tvSchendtime = itemView.findViewById(R.id.sch_end_time);

        }
    }




    }

