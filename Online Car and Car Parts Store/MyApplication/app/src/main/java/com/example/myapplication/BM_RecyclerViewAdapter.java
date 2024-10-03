package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BM_RecyclerViewAdapter extends RecyclerView.Adapter<BM_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;

    ArrayList<BikeModel> bikeModels;
    public BM_RecyclerViewAdapter(Context context, ArrayList<BikeModel> bikeModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.bikeModels = bikeModels;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public BM_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row, parent, false);
        return new  BM_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }
    public void onBindViewHolder(@NonNull BM_RecyclerViewAdapter.MyViewHolder holder, int position) {
        ImageView imageView = holder.imageView;
        holder.itemDescription.setText(bikeModels.get(position).getBikeName());
        holder.priceDesc.setText(bikeModels.get(position).getBikePrice());

        Glide.with(holder.itemView.getContext()).load(bikeModels.get(position).getImage()).into(imageView);
    }

    @Override
    public int getItemCount() {
        return bikeModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView itemDescription, priceDesc;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);

            itemDescription = itemView.findViewById(R.id.itemDescription);
            priceDesc = itemView.findViewById(R.id.priceDesc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
