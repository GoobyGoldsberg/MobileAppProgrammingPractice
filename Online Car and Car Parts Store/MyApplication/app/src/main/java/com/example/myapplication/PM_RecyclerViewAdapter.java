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

public class PM_RecyclerViewAdapter extends RecyclerView.Adapter<PM_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;

    ArrayList<PartModel> partModels;
    public PM_RecyclerViewAdapter(Context context, ArrayList<PartModel> partModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.partModels = partModels;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public PM_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row, parent, false);
        return new  PM_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }
    public void onBindViewHolder(@NonNull PM_RecyclerViewAdapter.MyViewHolder holder, int position) {
        ImageView imageView = holder.imageView;
        holder.itemDescription.setText(partModels.get(position).getPartName());
        holder.priceDesc.setText(partModels.get(position).getPartPrice());

        Glide.with(holder.itemView.getContext()).load(partModels.get(position).getImage()).into(imageView);
    }

    @Override
    public int getItemCount() {
        return partModels.size();
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
