package com.example.sistemperpustakaanuas.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sistemperpustakaanuas.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnListBuku, btnBukuDipinjam, btnRiwayatPinjam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnListBuku = findViewById(R.id.btn_list_buku);
        btnBukuDipinjam = findViewById(R.id.btn_buku_dipinjam);
        btnRiwayatPinjam = findViewById(R.id.btn_riwayat_peminjaman);

        btnListBuku.setOnClickListener(this);
        btnBukuDipinjam.setOnClickListener(this);
        btnRiwayatPinjam.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_list_buku:
                Intent intentListBuku = new Intent(HomeActivity.this, ListBukuActivity.class);
                startActivity(intentListBuku);
                break;
            case R.id.btn_buku_dipinjam:
                Intent intentBukuDipinjam = new Intent(HomeActivity.this, BukuDipinjamActivity.class);
                startActivity(intentBukuDipinjam);
                break;
            case R.id.btn_riwayat_peminjaman:
                Intent intentRiwayatPinjam = new Intent(HomeActivity.this, RiwayatPinjamActivity.class);
                startActivity(intentRiwayatPinjam);
                break;
        }
    }
}