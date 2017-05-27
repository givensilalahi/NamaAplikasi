package com.example.giventrisjeremia.namaaplikasi.interactor;

import com.example.giventrisjeremia.namaaplikasi.model.Gunung;
import com.example.giventrisjeremia.namaaplikasi.model.QuotesEntity;
import com.example.giventrisjeremia.namaaplikasi.util.BasePresenter;
import com.example.giventrisjeremia.namaaplikasi.util.BaseView;

import java.util.List;

/**
 * Created by Giventris Jeremia on 24/05/2017.
 */

public interface QuotesContract {
    interface View extends BaseView<Presenter> {

        void updateQuotes(List<QuotesEntity> quotesEntities);

        void updateGunung (List<Gunung> gunungs);

        void showProgress();

        void hideProgress();

        void loginSuccess(String username, String password);

        void loginError();

        void massageError();

        void showError();

        void nextId(int id);


    }

    interface Presenter extends BasePresenter<View> {

        void getQuotesHistory();

        void getGunungHistory();

        void login(String username, String password);

        void getDataInfo(String id);

        void setDataInfo(String namaGunung, String tinggiGunung, String fotoGunung);


    }
}
