package com.daggermvp.di.module;

import com.daggermvp.di.CustomScope;
import com.daggermvp.service.ProductService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by 'Nagarjuna' on 2/1/18.
 */

@Module
public class ApiModule {

    @Provides
    @CustomScope
    public ProductService getProductService(Retrofit retrofit) {
        return retrofit.create(ProductService.class);
    }


}
