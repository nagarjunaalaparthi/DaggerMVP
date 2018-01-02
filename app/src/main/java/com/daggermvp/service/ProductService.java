package com.daggermvp.service;

import com.daggermvp.model.Response;

import retrofit2.http.GET;
import rx.Observable;


/**
 * Created by 'Nagarjuna' on 2/1/18.
 */

public interface ProductService {


    @GET("/json")
    Observable<Response> getProducts();

}
