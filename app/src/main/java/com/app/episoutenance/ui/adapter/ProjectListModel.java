package com.app.episoutenance.ui.adapter;

import android.databinding.ObservableList;

import com.app.episoutenance.BR;
import com.app.episoutenance.R;
import com.app.episoutenance.api.models.Project;

import java.util.ArrayList;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by banal_a on 31/10/2016.
 */

public class ProjectListModel {
    public final ObservableList<Project> items;

    public final ItemView itemView = ItemView.of(BR.project, R.layout.item);

    public ProjectListModel(ObservableList<Project> items) {
        this.items = items;
    }

}
