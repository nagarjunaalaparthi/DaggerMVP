package com.daggermvp;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.daggermvp.databinding.ActivityMainBinding;
import com.daggermvp.model.Response;
import com.daggermvp.presenter.ProductPresenter;
import com.daggermvp.service.ProductService;
import com.daggermvp.service.ProductViewInterface;

import javax.inject.Inject;

import rx.Observable;

public class MainActivity extends AppCompatActivity implements ProductViewInterface {


    private ProductPresenter productPresenter;
    private ActivityMainBinding mainBinding;
    private ProgressDialog mDialog;

    @Inject
    ProductService productService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        resolveDependency();

        productPresenter = new ProductPresenter(this);
        productPresenter.onCreate();

        productPresenter.getProducts();
    }

    private void resolveDependency() {
        ((ProductsApplication) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        productPresenter.onResume();
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onResponse(Response response) {

        mainBinding.categoriesCountTextView.setText(response.getCategories().size() + " Categories");
        mainBinding.rankingCountTextView.setText(response.getRankings().size() + " Rankings");
    }

    @Override
    public Observable<Response> getResponse() {
        return productService.getProducts();
    }

    private void showProgressDialog() {
        if (mDialog == null) {
            mDialog = new ProgressDialog(MainActivity.this);
            mDialog.setIndeterminate(true);
            mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mDialog.setTitle("Downloading List");
            mDialog.setMessage("Please wait...");
        }
        mDialog.show();
    }
}
