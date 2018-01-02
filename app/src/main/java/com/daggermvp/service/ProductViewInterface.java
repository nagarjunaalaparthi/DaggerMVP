package com.daggermvp.service;

import com.daggermvp.model.Response;

import rx.Observable;

/**
 * Created by 'Nagarjuna' on 2/1/18.
 */

public interface ProductViewInterface {

    void onCompleted();

    void onError(String message);

    void onResponse(Response response);

    Observable<Response> getResponse();

}
