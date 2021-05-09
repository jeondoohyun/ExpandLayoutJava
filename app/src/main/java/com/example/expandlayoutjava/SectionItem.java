package com.example.expandlayoutjava;

import java.util.ArrayList;

public class SectionItem {
    public SectionItem(String title, ArrayList<String> itemList) {
        this.title = title;
        this.itemList = itemList;
    }

    public String title;
    public ArrayList<String> itemList;

}
