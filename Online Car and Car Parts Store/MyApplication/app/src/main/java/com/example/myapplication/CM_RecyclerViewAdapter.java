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

public class CM_RecyclerViewAdapter extends RecyclerView.Adapter<CM_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;

    ArrayList<CarModel> carModels;
    public CM_RecyclerViewAdapter(Context context, ArrayList<CarModel> carModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.carModels = carModels;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public CM_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row, parent, false);
        return new  CM_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }
    public void onBindViewHolder(@NonNull CM_RecyclerViewAdapter.MyViewHolder holder, int position) {
        ImageView imageView = holder.imageView;
        holder.itemDescription.setText(carModels.get(position).getCarName());
        holder.priceDesc.setText(carModels.get(position).getCarPrice());
        holder.typeDesc.setText(carModels.get(position).getCarType());

        Glide.with(holder.itemView.getContext()).load(carModels.get(position).getImage()).into(imageView);
    }

    @Override
    public int getItemCount() {
        return carModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView itemDescription, priceDesc, typeDesc;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);

            itemDescription = itemView.findViewById(R.id.itemDescription);
            priceDesc = itemView.findViewById(R.id.priceDesc);
            typeDesc = itemView.findViewById(R.id.typeDesc);

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
