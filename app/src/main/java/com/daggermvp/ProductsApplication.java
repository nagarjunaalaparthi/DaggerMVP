package com.daggermvp;

import android.app.Application;

import com.daggermvp.di.component.ApiComponent;
import com.daggermvp.di.component.DaggerApiComponent;
import com.daggermvp.di.component.DaggerNetworkComponent;
import com.daggermvp.di.component.NetworkComponent;
import com.daggermvp.di.module.NetworkModule;

/**
 * Created by 'Nagarjuna' on 2/1/18.
 */

public class ProductsApplication extends Application {

    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        resolveDependency();
    }


    private void resolveDependency() {
        apiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(BuildConfig.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
