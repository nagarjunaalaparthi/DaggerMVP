package com.daggermvp.presenter;

/**
 * Created by 'Nagarjuna' on 2/1/18.
 */

public interface Presenter {

    void onCreate();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
}
