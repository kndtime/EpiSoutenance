package com.app.episoutenance.dagger.component;

import com.app.episoutenance.dagger.module.AppModule;
import com.app.episoutenance.dagger.module.RestModule;
import com.app.episoutenance.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by banal_a on 31/10/2016.
 */

@Singleton
@Component(modules = {AppModule.class, RestModule.class})
public interface TestComponent {
    void inject(MainActivity activity);
}
