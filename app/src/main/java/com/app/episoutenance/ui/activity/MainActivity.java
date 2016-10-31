package com.app.episoutenance.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.app.episoutenance.Application;
import com.app.episoutenance.R;
import com.app.episoutenance.api.EpiSoutenanceApi;
import com.app.episoutenance.api.models.Project;
import com.app.episoutenance.databinding.ActivityMainBinding;
import com.app.episoutenance.ui.adapter.ProjectListModel;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application.getmRestComponent().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Call<ArrayList<Project>> call = retrofit.create(EpiSoutenanceApi.class).getProjectList();
        call.enqueue(new Callback<ArrayList<Project>>() {
            @Override
            public void onResponse(Call<ArrayList<Project>> call,
                                   Response<ArrayList<Project>> response) {
                if (!response.isSuccessful())
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                ProjectListModel model = new ProjectListModel(response.body());
                binding.setList(model);
            }

            @Override
            public void onFailure(Call<ArrayList<Project>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
