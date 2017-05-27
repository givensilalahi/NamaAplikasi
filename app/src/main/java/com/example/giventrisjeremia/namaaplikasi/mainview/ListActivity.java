package com.example.giventrisjeremia.namaaplikasi.mainview;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.giventrisjeremia.namaaplikasi.R;
import com.example.giventrisjeremia.namaaplikasi.adapter.AdapterMain;
import com.example.giventrisjeremia.namaaplikasi.databinding.ActivityListBinding;
import com.example.giventrisjeremia.namaaplikasi.interactor.QuotesContract;
import com.example.giventrisjeremia.namaaplikasi.model.Gunung;
import com.example.giventrisjeremia.namaaplikasi.model.QuotesEntity;
import com.example.giventrisjeremia.namaaplikasi.presenter.MainPresenter;
import com.example.giventrisjeremia.namaaplikasi.service.CoreInteractorImpl;

import java.util.List;

public class ListActivity extends AppCompatActivity implements QuotesContract.View {
    private ActivityListBinding listBinding;

    private AdapterMain mAdapterMain;

    private RecyclerView mRecyclerView;

    private List<QuotesEntity> mQuotesEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listBinding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        initRecyclerView();
        QuotesContract.Presenter mPresenter = initPresenter();
        mPresenter.bind(this);

        showProgress();
        mPresenter.getQuotesHistory();

    }

    private void initRecyclerView() {
        mRecyclerView = listBinding.idRecyclerView;
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public QuotesContract.Presenter initPresenter() {
        return new MainPresenter(new CoreInteractorImpl(getApplicationContext()));
    }

    @Override
    public void updateQuotes(List<QuotesEntity> quotesEntities) {
        if(mAdapterMain == null){
            mAdapterMain = new AdapterMain(quotesEntities, this);
        }
        if(mRecyclerView.getAdapter() == null) {
            mRecyclerView.setAdapter(mAdapterMain);
        } else {
            Toast.makeText(this, "+ not added", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void updateGunung(List<Gunung> gunungs) {

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loginSuccess(String username, String password) {

    }

    @Override
    public void loginError() {

    }

    @Override
    public void massageError() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void nextId(int id) {
        Intent i = new Intent(this,ScrollingActivity.class);
        i.putExtra("id",id);
        startActivity(i);
    }
}
