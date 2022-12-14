package com.example.tablesapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NumbersRvAdapter extends RecyclerView.Adapter<NumbersRvAdapter.MyViewHolder> {

    List<String> mTables;
    LayoutInflater mLayoutInflate;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mTextViewTable;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTable = itemView.findViewById(R.id.tvNumbers);
        }
    }

    NumbersRvAdapter(Context context, List<String> data){
        this.mLayoutInflate = LayoutInflater.from(context);
        this.mTables = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflate.inflate(R.layout.recyclerview_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String tables = mTables.get(position);
        holder.mTextViewTable.setText(tables);
    }

    @Override
    public int getItemCount() {
        return mTables.size();
    }
}
