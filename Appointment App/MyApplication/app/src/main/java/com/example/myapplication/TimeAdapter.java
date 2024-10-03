package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<Time> times;

    int selectedPosition = RecyclerView.NO_POSITION;

    public TimeAdapter(Context context, ArrayList<Time> times, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.times = times;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public TimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.time_block, parent, false);
        return new TimeAdapter.ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeAdapter.ViewHolder holder, int position) {

        holder.timeText.setText(times.get(position).getTime());



    }

    @Override
    public int getItemCount() {
        return times.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView timeText, dateInfo;
        Button bookButton;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            timeText = itemView.findViewById(R.id.timeTextView);
            dateInfo = itemView.findViewById(R.id.dateInfoDay);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    if (recyclerViewInterface != null) {
                        int position = getBindingAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);

                        }

                    }
                }
            });






        }



    }

}