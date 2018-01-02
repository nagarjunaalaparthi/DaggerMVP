package com.daggermvp.di.component;

import com.daggermvp.MainActivity;
import com.daggermvp.di.CustomScope;
import com.daggermvp.di.module.ApiModule;

import dagger.Component;

/**
 * Created by 'Nagarjuna' on 2/1/18.
 */

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity activity);
}
