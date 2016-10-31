package com.app.episoutenance.api;

import com.app.episoutenance.api.models.Defense;
import com.app.episoutenance.api.models.Project;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by banal_a on 30/10/2016.
 */

public interface EpiSoutenanceApi {

    @GET("/project")
    Call<ArrayList<Project>> getProjectList();

    @GET("/project/{id}")
    Call<Project> getProjectById(@Path("id") int id);


}
