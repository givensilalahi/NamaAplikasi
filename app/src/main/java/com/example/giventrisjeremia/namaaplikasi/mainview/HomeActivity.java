package com.example.giventrisjeremia.namaaplikasi.mainview;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.giventrisjeremia.namaaplikasi.R;
import com.example.giventrisjeremia.namaaplikasi.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding homeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        Intent i = getIntent();
        setTitle("Beranda");
        Toast.makeText(this, "Selamat Datang " + i.getStringExtra("username"), Toast.LENGTH_SHORT).show();
        homeBinding.idUserhome.setText(i.getStringExtra("username"));

    }

    public void onClickCalc(View view){
        Intent i = new Intent(this, CalcActivity.class);
        startActivity(i);
    }

    public void onClickMount(View view){
        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);
    }
}
