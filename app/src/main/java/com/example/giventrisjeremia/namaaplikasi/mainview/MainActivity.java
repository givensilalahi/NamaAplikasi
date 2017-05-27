package com.example.giventrisjeremia.namaaplikasi.mainview;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.giventrisjeremia.namaaplikasi.R;
import com.example.giventrisjeremia.namaaplikasi.databinding.ActivityMainBinding;
import com.example.giventrisjeremia.namaaplikasi.interactor.QuotesContract;
import com.example.giventrisjeremia.namaaplikasi.model.Gunung;
import com.example.giventrisjeremia.namaaplikasi.model.QuotesEntity;
import com.example.giventrisjeremia.namaaplikasi.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements QuotesContract.View {
    private ActivityMainBinding mainBinding;
    private QuotesContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main );

        presenter = new MainPresenter(this);

        mainBinding.idButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(mainBinding.idUsername.getText().toString(),
                        mainBinding.idPassword.getText().toString());
            }
        });

    }

    @Override
    public void updateQuotes(List<QuotesEntity> quotesEntities) {

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

        Toast.makeText(this, "Login Successfully!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", username);
        i.putExtra("password", password);
        startActivity(i);
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Username dan Password salah!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void massageError() {
        Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {

    }

    @Override
    public void nextId(int id) {

    }

    @Override
    public QuotesContract.Presenter initPresenter() {
        return null;
    }
}
