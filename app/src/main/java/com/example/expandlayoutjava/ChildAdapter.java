package com.example.expandlayoutjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expandlayoutjava.R;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<String> childItem;

    public ChildAdapter(Context context, ArrayList<String> childItem) {
        this.context = context;
        this.childItem = childItem;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        VH holder = new VH(itemview);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH) holder;
        vh.row_title.setText(childItem.get(position));

    }

    @Override
    public int getItemCount() {
        return childItem.size();
    }

    class VH extends RecyclerView.ViewHolder {
        TextView row_title;
        LinearLayout LinearLayout_row;

        public VH(@NonNull View itemView) {
            super(itemView);
            row_title = itemView.findViewById(R.id.row_title);
            LinearLayout_row = itemView.findViewById(R.id.LinearLayout_row);

            LinearLayout_row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, childItem.get(getLayoutPosition()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
