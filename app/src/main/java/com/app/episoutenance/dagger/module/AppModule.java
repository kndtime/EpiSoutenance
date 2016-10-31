package com.app.episoutenance.dagger.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by banal_a on 30/10/2016.
 */
@Module
public class AppModule {
    Application Instance;

    public AppModule(Application instance) {
        Instance = instance;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return Instance;
    }

}
