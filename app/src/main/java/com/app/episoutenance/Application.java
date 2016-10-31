package com.app.episoutenance;

import com.app.episoutenance.dagger.component.DaggerTestComponent;
import com.app.episoutenance.dagger.component.TestComponent;
import com.app.episoutenance.dagger.module.AppModule;
import com.app.episoutenance.dagger.module.RestModule;

/**
 * Created by banal_a on 31/10/2016.
 */

public class Application extends android.app.Application {

    private static String BASE_URL = "https://episoutenanceapi.cormery.eu";
    static TestComponent mRestComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mRestComponent = DaggerTestComponent.builder()
                .appModule(new AppModule(this))
                .restModule(new RestModule(BASE_URL))
                .build();
    }

    public static TestComponent getmRestComponent() {
        return mRestComponent;
    }
}
