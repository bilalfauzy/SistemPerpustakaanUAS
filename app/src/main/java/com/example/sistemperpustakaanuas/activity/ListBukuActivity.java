package com.example.sistemperpustakaanuas.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemperpustakaanuas.ApiCallback;
import com.example.sistemperpustakaanuas.ClickListener;
import com.example.sistemperpustakaanuas.R;
import com.example.sistemperpustakaanuas.adapter.ListBukuAdapter;
import com.example.sistemperpustakaanuas.apiservice.ApiClient;
import com.example.sistemperpustakaanuas.apiservice.ApiInterface;
import com.example.sistemperpustakaanuas.modeldata.DataBuku;
import com.example.sistemperpustakaanuas.modeldata.GetDataBuku;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBukuActivity extends AppCompatActivity {
    public static ListBukuActivity lb;
    private RecyclerView rvListBuku;
    private ApiInterface mApiInterface;
    private RecyclerView.Adapter listAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ApiCallback apiCallback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buku);

        rvListBuku = findViewById(R.id.rv_list_buku);
        rvListBuku.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        rvListBuku.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        lb = this;
        refresh();
    }

    private void refresh() {
        Call<GetDataBuku> getDataBukuCall = mApiInterface.getDataBuku();
        getDataBukuCall.enqueue(new Callback<GetDataBuku>() {
            @Override
            public void onResponse(Call<GetDataBuku> call, Response<GetDataBuku> response) {
                List<DataBuku> listBuku = response.body().getListBuku();
                listAdapter = new ListBukuAdapter(listBuku, getApplicationContext());
                apiCallback.onSuccessGetBuku(listBuku);
                rvListBuku.setAdapter(listAdapter);
                Log.d("Retrofit Get", "Jumlah data buku :" +String.valueOf(listBuku.size()));
            }

            @Override
            public void onFailure(Call<GetDataBuku> call, Throwable t) {
                Log.d("Retrofit Get", t.toString());
            }
        });
    }
}
