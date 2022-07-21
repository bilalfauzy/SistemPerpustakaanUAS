package com.example.sistemperpustakaanuas.activity;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_dipinjam);

        rvListBuku = findViewById(R.id.rv_list_buku);
        rvListBuku.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        rvListBuku.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        ApiCallback apiCallback = new ApiCallback() {
            @Override
            public void onSuccessGetBuku(List<DataBuku> listBuku) {
                listAdapter = new ListPinjamanAdapter(listBuku, getApplicationContext());
                rvListBuku.setAdapter(listAdapter);

            }
        };
    }

}
