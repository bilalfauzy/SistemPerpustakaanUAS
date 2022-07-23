package com.example.sistemperpustakaanuas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemperpustakaanuas.ClickListener;
import com.example.sistemperpustakaanuas.R;
import com.example.sistemperpustakaanuas.adapter.ListPinjamanAdapter;
import com.example.sistemperpustakaanuas.adapter.ListRiwayatPinjamAdapter;
import com.example.sistemperpustakaanuas.apiservice.ApiClient;
import com.example.sistemperpustakaanuas.apiservice.ApiInterface;
import com.example.sistemperpustakaanuas.modeldata.DataBuku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RiwayatPinjamActivity extends AppCompatActivity {
    private RecyclerView rvListBuku;
    private RecyclerView.Adapter listAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_pinjam);

        rvListBuku = findViewById(R.id.rv_riwayat_pinjam);
        rvListBuku.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        rvListBuku.setLayoutManager(mLayoutManager);

        List<DataBuku> listDataBuku = new ArrayList<DataBuku>();
        Intent getIntent = getIntent();
        listDataBuku = (List<DataBuku>) getIntent.getSerializableExtra("listbuku1");

        List<DataBuku> finalListDataBuku = listDataBuku;
        listAdapter = new ListRiwayatPinjamAdapter(listDataBuku, this);
        rvListBuku.setAdapter(listAdapter);
    }
}
