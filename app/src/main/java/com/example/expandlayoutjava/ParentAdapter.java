package com.example.expandlayoutjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expandlayoutjava.R;
import com.skydoves.expandablelayout.ExpandableLayout;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter{
    private ArrayList<SectionItem> items;
    private Context context;

    public ParentAdapter(ArrayList<SectionItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_section,parent,false);
        VH holder = new VH(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH)holder;
        vh.expandableLayout.setParentLayoutResource(R.layout.item_section_parent);
        vh.expandableLayout.setSecondLayoutResource(R.layout.item_section_child);
        TextView title = vh.expandableLayout.getParentLayout().findViewById(R.id.title);
        title.setText(items.get(position).title);

        ChildAdapter childAdapter = new ChildAdapter(context, items.get(position).itemList);
        RecyclerView recyclerView = vh.expandableLayout.getSecondLayout().findViewById(R.id.recyclerViewChild);
        recyclerView.setAdapter(childAdapter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    // todo : 생성자에서 완성된 items를 한번만 받자

    class VH extends RecyclerView.ViewHolder{
        ExpandableLayout expandableLayout;

        public VH(@NonNull View itemView) {
            super(itemView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            expandableLayout.setOnClickListener((v) -> {
                if (expandableLayout.isExpanded()) {
                    expandableLayout.collapse();
                } else {
                    expandableLayout.expand();
                }
            });
        }
    }

}
