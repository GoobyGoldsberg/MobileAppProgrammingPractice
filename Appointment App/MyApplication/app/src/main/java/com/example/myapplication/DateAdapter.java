package com.example.myapplication;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private Context context;
    private ArrayList<Date> dates;


    public DateAdapter(Context context, ArrayList<Date> dates, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.dates = dates;
        this.recyclerViewInterface = recyclerViewInterface;

    }

    @NonNull
    @Override
    public DateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.date_block, parent, false);
        return new DateAdapter.ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull DateAdapter.ViewHolder holder, int position) {

        holder.dayText.setText(dates.get(position).getDay());
        holder.dateText.setText(dates.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return  dates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dayText, dateText;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            dayText = itemView.findViewById(R.id.dayTextView);
            dateText = itemView.findViewById(R.id.dateTextView);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (recyclerViewInterface != null) {
                        int position = getBindingAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);

                        }

                    }

                    Intent i = new Intent(v.getContext(), TimeBookingActivity.class);
                    i.putExtra("selectedDate", dates.get(getBindingAdapterPosition()).getDate());
                    i.putExtra("selectedDay", dates.get(getBindingAdapterPosition()).getDay());
                    v.getContext().startActivity(i);
                }
            });


        }

    }
}