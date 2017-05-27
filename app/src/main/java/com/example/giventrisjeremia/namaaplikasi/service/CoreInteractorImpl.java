package com.example.giventrisjeremia.namaaplikasi.service;

import android.content.Context;

import com.example.giventrisjeremia.namaaplikasi.interactor.CoreInteractor;
import com.example.giventrisjeremia.namaaplikasi.model.Gunung;
import com.example.giventrisjeremia.namaaplikasi.model.QuotesEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Giventris Jeremia on 24/05/2017.
 */

public class CoreInteractorImpl implements CoreInteractor {

    private CoreApiService mCoreApi;
    private Context mContext;

    public CoreInteractorImpl(Context context){
        mCoreApi = CoreApiServiceBuilder.provideCoreApiService();
        mContext  = context;
    }

    @Override
    public Observable<List<QuotesEntity>> getQuotesHistoryTransaction() {
        return mCoreApi.getQuotes();
    }

    @Override
    public Observable<List<Gunung>> getGunungHistoryTransaction() {
        return mCoreApi.getGunung();
    }
}
