package com.example.sistemperpustakaanuas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemperpustakaanuas.ApiCallback;
import com.example.sistemperpustakaanuas.R;
import com.example.sistemperpustakaanuas.adapter.ListBukuAdapter;
import com.example.sistemperpustakaanuas.adapter.ListPinjamanAdapter;
import com.example.sistemperpustakaanuas.apiservice.ApiClient;
import com.example.sistemperpustakaanuas.apiservice.ApiInterface;
import com.example.sistemperpustakaanuas.modeldata.DataBuku;
import com.example.sistemperpustakaanuas.modeldata.GetDataBuku;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class BukuDipinjamActivity extends AppCompatActivity{
    public static ListBukuActivity lb;
    private RecyclerView rvListBuku;
    private ApiInterface mApiInterface;
    private RecyclerView.Adapter listAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DataBuku dataBuku;
    private List<DataBuku> listDataBuku;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_dipinjam);

        rvListBuku = findViewById(R.id.rv_list_buku);
        rvListBuku.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        rvListBuku.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        Intent getIntent = getIntent();
        String idBuku = getIntent.getStringExtra("id_buku");
        String sampulBuku = getIntent.getStringExtra("sampul_buku");
        String judulBuku = getIntent.getStringExtra("judul_buku");
        String penulisBuku = getIntent.getStringExtra("penulis");
        String penerbitBuku = getIntent.getStringExtra("penerbit");
        String kategoriBuku = getIntent.getStringExtra("kategori");
        String stokBuku = getIntent.getStringExtra("stok_buku");
        String rak = getIntent.getStringExtra("rak");
        String rakBaris = getIntent.getStringExtra("rak_baris");

        listDataBuku.add(new DataBuku(idBuku, judulBuku, sampulBuku, penulisBuku, stokBuku, penerbitBuku, kategoriBuku, rak, rakBaris));

        listAdapter = new ListPinjamanAdapter(listDataBuku, getApplicationContext());
        rvListBuku.setAdapter(listAdapter);

    }

}
