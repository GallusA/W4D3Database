package com.example.gallusawa.w4d3database;

/**
 * Created by gallusawa on 8/23/17.
 */

public interface BasePresenter<V extends  BaseView>{
    void attachView(V view);
    void detachView();
}
