package com.app.episoutenance.dagger.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.app.episoutenance.api.EpiSoutenanceApi;
import com.app.episoutenance.api.gson.DefenseListDeserializer;
import com.app.episoutenance.api.gson.DefeseDeserializer;
import com.app.episoutenance.api.gson.ProjectDeserializer;
import com.app.episoutenance.api.gson.ProjectListDeserializer;
import com.app.episoutenance.api.gson.StudentDeserializer;
import com.app.episoutenance.api.models.Defense;
import com.app.episoutenance.api.models.Project;
import com.app.episoutenance.api.models.Student;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by banal_a on 30/10/2016.
 */

@Module
public class RestModule {

    String mBaseUrl;

    public RestModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Type mDefenseType = new TypeToken<Defense>(){}.getType();
        Type mDefenseListType = new TypeToken<ArrayList<Defense>>(){}.getType();
        Type mProjectType = new TypeToken<Project>(){}.getType();
        Type mProjectListType = new TypeToken<ArrayList<Project>>(){}.getType();
        Type mStudentType = new TypeToken<Student>(){}.getType();

        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.registerTypeAdapter(mDefenseType, new DefeseDeserializer());
        gsonBuilder.registerTypeAdapter(mDefenseListType, new DefenseListDeserializer());
        gsonBuilder.registerTypeAdapter(mProjectType, new ProjectDeserializer());
        gsonBuilder.registerTypeAdapter(mProjectListType, new ProjectListDeserializer());
        gsonBuilder.registerTypeAdapter(mStudentType, new StudentDeserializer());
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().cache(cache).build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
    }

}
