package com.example.sistemperpustakaanuas.apiservice;

import com.example.sistemperpustakaanuas.modeldata.GetDataBuku;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("getdatabuku")
    Call<GetDataBuku> getDataBuku();
}
