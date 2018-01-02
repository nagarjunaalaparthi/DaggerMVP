package com.daggermvp.di.module;

import android.app.Application;

import com.daggermvp.ProductsApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 'Nagarjuna' on 2/1/18.
 */

@Module
public class AppModule {
    private ProductsApplication productsApplication;


    public AppModule(ProductsApplication productsApplication) {
        this.productsApplication = productsApplication;
    }

    @Provides
    @Singleton
    public Application getProductsApplication() {
        return productsApplication;
    }
}
