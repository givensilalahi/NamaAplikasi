package com.example.giventrisjeremia.namaaplikasi.interactor;

import com.example.giventrisjeremia.namaaplikasi.model.Gunung;
import com.example.giventrisjeremia.namaaplikasi.model.QuotesEntity;

import java.util.List;

/**
 * Created by Giventris Jeremia on 24/05/2017.
 */

public interface CoreInteractor {
    rx.Observable<List<QuotesEntity>> getQuotesHistoryTransaction();
    rx.Observable<List<Gunung>> getGunungHistoryTransaction();
}
