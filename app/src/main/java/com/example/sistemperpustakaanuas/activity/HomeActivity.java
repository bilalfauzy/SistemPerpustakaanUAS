package com.example.sistemperpustakaanuas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.sistemperpustakaanuas.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnListBuku, btnBukuDipinjam, btnRiwayatPinjam;
    BottomNavigationView bottomNavigationView;

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

        bottomNavigationView = findViewById(R.id.bottom_nav_id);
        bottomNavigationView.setSelectedItemId(R.id.home_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_menu:
                        break;
                    case R.id.profil_menu:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        break;
                }
                return true;
            }
        });
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}