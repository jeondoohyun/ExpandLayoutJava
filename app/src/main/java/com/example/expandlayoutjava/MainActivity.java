package com.example.expandlayoutjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.expandlayoutjava.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ParentAdapter adapter;
    private ArrayList<SectionItem> items = new ArrayList<>();

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("내용11");
        itemList.add("내용12");
        items.add(new SectionItem("제목1",itemList));

        itemList = new ArrayList<>();
        itemList.add("내용21");
        itemList.add("내용22");
        items.add(new SectionItem("제목2",itemList));

        itemList = new ArrayList<>();
        itemList.add("내용31");
        itemList.add("내용32");
        items.add(new SectionItem("제목3",itemList));

        itemList = new ArrayList<>();
        itemList.add("내용41");
        itemList.add("내용42");
        items.add(new SectionItem("제목4",itemList));

        itemList = new ArrayList<>();
        itemList.add("내용51");
        itemList.add("내용52");
        items.add(new SectionItem("제목5",itemList));

        itemList = new ArrayList<>();
        itemList.add("내용61");
        itemList.add("내용62");
        items.add(new SectionItem("제목6",itemList));

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ParentAdapter(items, this);
        recyclerView.setAdapter(adapter);
    }
}