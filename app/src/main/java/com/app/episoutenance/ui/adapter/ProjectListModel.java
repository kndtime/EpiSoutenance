package com.app.episoutenance.ui.adapter;

import com.app.episoutenance.BR;
import com.app.episoutenance.R;
import com.app.episoutenance.api.models.Project;

import java.util.ArrayList;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by banal_a on 31/10/2016.
 */

public class ProjectListModel {
    private final ArrayList<Project> items;

    public void setItemView(ItemView itemView) {
        this.itemView = itemView;
    }

    private ItemView itemView = ItemView.of(BR.project, R.layout.item);

    public ProjectListModel(ArrayList<Project> items) {
        this.items = items;
    }



    public ArrayList<Project> getItems() {
        return items;
    }

    public ItemView getItemview() {
        return itemView;
    }


}
