package com.daggermvp.presenter;

import com.daggermvp.model.Response;
import com.daggermvp.service.ProductViewInterface;

import rx.Observer;

/**
 * Created by 'Nagarjuna' on 2/1/18.
 */

public class ProductPresenter extends BasePresenter implements Observer<Response> {

    ProductViewInterface viewInterface;

    public ProductPresenter(ProductViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void onCompleted() {
        if (viewInterface != null) {
            viewInterface.onCompleted();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (viewInterface != null) {
            viewInterface.onError(e.getMessage());
        }
    }

    @Override
    public void onNext(Response response) {
        if (viewInterface != null) {
            viewInterface.onResponse(response);
        }
    }

    public void getProducts() {
        unSubscribeAll();
        subscribe(viewInterface.getResponse(), ProductPresenter.this);
    }
}
