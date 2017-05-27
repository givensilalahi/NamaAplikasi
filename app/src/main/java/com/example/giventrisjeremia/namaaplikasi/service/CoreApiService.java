package com.example.giventrisjeremia.namaaplikasi.service;

import com.example.giventrisjeremia.namaaplikasi.model.Gunung;
import com.example.giventrisjeremia.namaaplikasi.model.QuotesEntity;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by Giventris Jeremia on 24/05/2017.
 */

public interface CoreApiService {

    String END_POINT = "questions";

    @GET(END_POINT)
    rx.Observable<List<QuotesEntity>> getQuotes();
    rx.Observable<List<Gunung>> getGunung();
}
