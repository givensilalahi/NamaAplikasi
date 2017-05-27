package com.example.giventrisjeremia.namaaplikasi.util;

/**
 * Created by Giventris Jeremia on 24/05/2017.
 */

public interface BasePresenter<V> {
    void bind(V view);
    void unbind();
}
