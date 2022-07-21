package com.example.sistemperpustakaanuas;

import com.example.sistemperpustakaanuas.modeldata.DataBuku;

import java.util.List;

public interface ApiCallback {
    void onSuccessGetBuku(List<DataBuku> listBuku);
}
