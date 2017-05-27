package com.example.giventrisjeremia.namaaplikasi.mainview;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giventrisjeremia.namaaplikasi.R;
import com.example.giventrisjeremia.namaaplikasi.databinding.ActivityScrollingBinding;
import com.example.giventrisjeremia.namaaplikasi.interactor.QuotesContract;
import com.example.giventrisjeremia.namaaplikasi.model.Gunung;
import com.example.giventrisjeremia.namaaplikasi.service.CoreApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScrollingActivity extends AppCompatActivity implements QuotesContract.Presenter{
    private ActivityScrollingBinding scrollingBinding;

    private List<Gunung> gunungs;

    private Context mContext;

    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";

    private TextView isi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scrollingBinding = DataBindingUtil.setContentView(this, R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String i = intent.getStringExtra("id");
        getDataInfo(i);
    }


    @Override
    public void bind(QuotesContract.View view) {

    }

    @Override
    public void unbind() {

    }

    @Override
    public void getQuotesHistory() {

    }

    @Override
    public void getGunungHistory() {

    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public void getDataInfo(String id) {
        final String ids = id;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CoreApiService serviceApi = retrofit.create(CoreApiService.class);
        Call<List<Gunung>> call = (Call<List<Gunung>>) serviceApi.getGunung();
        call.enqueue(new Callback<List<Gunung>>() {
            @Override
            public void onResponse(Call<List<Gunung>> call, Response<List<Gunung>> response) {
                gunungs = response.body();
                String namaGunung = gunungs.get(Integer.parseInt(ids)).getNamaGunung();
                String tinggiGunung = gunungs.get(Integer.parseInt(ids)).getTinggiGunung();
                String fotoGunung = gunungs.get(Integer.parseInt(ids)).getFotoGunung();
                setDataInfo(namaGunung,tinggiGunung,fotoGunung);
            }

            @Override
            public void onFailure(Call<List<Gunung>> call, Throwable t) {
                Toast.makeText(mContext, R.string.txt_errorconnection, Toast.LENGTH_SHORT).show();
            }


        });
    }

    @Override
    public void setDataInfo(String namaGunung, String tinggiGunung, String fotoGunung) {
        setTitle(namaGunung);
        isi = (TextView) findViewById(R.id.idTinggi);
        isi.setText(tinggiGunung);
    }
}
