package com.example.sistemperpustakaanuas.activity;

import android.content.Intent;
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
import com.example.sistemperpustakaanuas.adapter.ListPinjamanAdapter;
import com.example.sistemperpustakaanuas.apiservice.ApiClient;
import com.example.sistemperpustakaanuas.apiservice.ApiInterface;
import com.example.sistemperpustakaanuas.modeldata.DataBuku;
import com.example.sistemperpustakaanuas.modeldata.GetDataBuku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BukuDipinjamActivity extends AppCompatActivity{
    public static ListBukuActivity lb;
    private RecyclerView rvListBuku;
    private ApiInterface mApiInterface;
    private RecyclerView.Adapter listAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ApiCallback apiCallback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_dipinjam);

        rvListBuku = findViewById(R.id.rv_list_pinjaman);
        rvListBuku.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        rvListBuku.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        List<DataBuku> listDataBuku = new ArrayList<DataBuku>();
        Intent getIntent = getIntent();
        listDataBuku = (List<DataBuku>) getIntent.getSerializableExtra("listbuku");

        List<DataBuku> finalListDataBuku = listDataBuku;
        listAdapter = new ListPinjamanAdapter(listDataBuku, this, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                Toast.makeText(getApplicationContext(), "buku dikembalikan", Toast.LENGTH_SHORT).show();
                finalListDataBuku.remove(position);
                listAdapter.notifyItemRemoved(position);
                listAdapter.notifyItemRangeChanged(position, finalListDataBuku.size());

                Intent i = new Intent(getApplicationContext(), RiwayatPinjamActivity.class);
                i.putExtra("listbuku1", (Serializable) finalListDataBuku);
                startActivity(i);
            }
        });
        rvListBuku.setAdapter(listAdapter);
//        String idBuku = getIntent.getStringExtra("id_buku");
//        String sampulBuku = getIntent.getStringExtra("sampul_buku");
//        String judulBuku = getIntent.getStringExtra("judul_buku");
//        String penulisBuku = getIntent.getStringExtra("penulis");
//        String penerbitBuku = getIntent.getStringExtra("penerbit");
//        String kategoriBuku = getIntent.getStringExtra("kategori");
//        String stokBuku = getIntent.getStringExtra("stok_buku");
//        String rak = getIntent.getStringExtra("rak");
//        String rakBaris = getIntent.getStringExtra("rak_baris");

        //refresh();

    }
//
//    private void refresh() {
//        Call<GetDataBuku> getDataBukuCall = mApiInterface.getDataBuku();
//        getDataBukuCall.enqueue(new Callback<GetDataBuku>() {
//            @Override
//            public void onResponse(Call<GetDataBuku> call, Response<GetDataBuku> response) {
//                List<DataBuku> listBuku = response.body().getListBuku();
//                Log.d("Retrofit Get", "Jumlah data buku :" +String.valueOf(listBuku.size()));
//            }
//
//            @Override
//            public void onFailure(Call<GetDataBuku> call, Throwable t) {
//                Log.d("Retrofit Get", t.toString());
//            }
//        });
//    }

}
