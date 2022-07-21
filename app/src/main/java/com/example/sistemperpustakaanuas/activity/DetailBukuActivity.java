package com.example.sistemperpustakaanuas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sistemperpustakaanuas.R;
import com.example.sistemperpustakaanuas.modeldata.DataBuku;

import java.util.List;

public class DetailBukuActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView sampulBuku;
    private TextView tvJudulDetail, tvPenulisDetail, tvPenerbitDetail, tvKategoriDetail, tvStokDetail;
    private Button btnPinjamBuku, btnKembali;
    private List<DataBuku> listDataBuku;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        sampulBuku = findViewById(R.id.imgDetailBuku);
        tvJudulDetail = findViewById(R.id.tvJudulDetail);
        tvPenulisDetail = findViewById(R.id.tvPenulisDetail);
        tvPenerbitDetail = findViewById(R.id.tvPenerbitDetail);
        tvKategoriDetail = findViewById(R.id.tvKategoriDetail);
        tvStokDetail = findViewById(R.id.tvStokBuku);

        Intent mIntent = getIntent();
        sampulBuku.setImageResource(R.drawable.ic_baseline_book_24);
        tvJudulDetail.setText("Judul : " +mIntent.getStringExtra("judul_buku"));
        tvPenulisDetail.setText("Penulis : " +mIntent.getStringExtra("penulis"));
        tvPenerbitDetail.setText("Penerbit : " +mIntent.getStringExtra("penerbit"));
        tvKategoriDetail.setText("Kategori : " +mIntent.getStringExtra("kategori"));
        tvStokDetail.setText("Stok : " +mIntent.getStringExtra("stok_buku"));

        btnPinjamBuku = findViewById(R.id.btnPinjamBuku);
        btnKembali = findViewById(R.id.btnKembali);
        btnPinjamBuku.setOnClickListener(this);
        btnKembali.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnKembali:
                onBackPressed();
                break;
            case R.id.btnPinjamBuku:
                Toast.makeText(this, "Dipinjam", Toast.LENGTH_SHORT).show();
                Intent intentBukuDipinjam = new Intent(DetailBukuActivity.this, BukuDipinjamActivity.class);
                startActivity(intentBukuDipinjam
                        .putExtra("judul_buku", tvJudulDetail.getText())
                        .putExtra("penulis", tvPenulisDetail.getText())
                        .putExtra("penerbit", tvPenerbitDetail.getText())
                        .putExtra("kategori", tvKategoriDetail.getText())
                        .putExtra("stok_buku", tvStokDetail.getText()));
                break;
        }

    }
}
