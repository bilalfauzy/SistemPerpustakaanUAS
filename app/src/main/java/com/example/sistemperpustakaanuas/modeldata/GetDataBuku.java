package com.example.sistemperpustakaanuas.modeldata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDataBuku {
    @SerializedName("result")
    private List<DataBuku> listBuku;

    public List<DataBuku> getListBuku() {
        return listBuku;
    }

    public void setListBuku(List<DataBuku> listBuku) {
        this.listBuku = listBuku;
    }
}
