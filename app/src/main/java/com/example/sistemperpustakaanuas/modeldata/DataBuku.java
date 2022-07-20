package com.example.sistemperpustakaanuas.modeldata;

import com.google.gson.annotations.SerializedName;

public class DataBuku {
    @SerializedName("id")
    private String id_buku;
    @SerializedName("judul")
    private String judul_buku;
    @SerializedName("sampul")
    private String sampul_buku;
    @SerializedName("penulis")
    private String penulis_buku;
    @SerializedName("stok")
    private int stok_buku;
    @SerializedName("nama_penerbit")
    private String penerbit_buku;
    @SerializedName("nama_kategori")
    private String kategori_buku;
    @SerializedName("rak")
    private String rak_buku;
    @SerializedName("baris")
    private String rak_baris_buku;

    public DataBuku(String id_buku, String judul_buku, String sampul_buku, String penulis_buku, int stok_buku, String penerbit_buku, String kategori_buku, String rak_buku, String rak_baris_buku) {
        this.id_buku = id_buku;
        this.judul_buku = judul_buku;
        this.sampul_buku = sampul_buku;
        this.penulis_buku = penulis_buku;
        this.stok_buku = stok_buku;
        this.penerbit_buku = penerbit_buku;
        this.kategori_buku = kategori_buku;
        this.rak_buku = rak_buku;
        this.rak_baris_buku = rak_baris_buku;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public String getJudul_buku() {
        return judul_buku;
    }

    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
    }

    public String getSampul_buku() {
        return sampul_buku;
    }

    public void setSampul_buku(String sampul_buku) {
        this.sampul_buku = sampul_buku;
    }

    public String getPenulis_buku() {
        return penulis_buku;
    }

    public void setPenulis_buku(String penulis_buku) {
        this.penulis_buku = penulis_buku;
    }

    public int getStok_buku() {
        return stok_buku;
    }

    public void setStok_buku(int stok_buku) {
        this.stok_buku = stok_buku;
    }

    public String getPenerbit_buku() {
        return penerbit_buku;
    }

    public void setPenerbit_buku(String penerbit_buku) {
        this.penerbit_buku = penerbit_buku;
    }

    public String getKategori_buku() {
        return kategori_buku;
    }

    public void setKategori_buku(String kategori_buku) {
        this.kategori_buku = kategori_buku;
    }

    public String getRak_buku() {
        return rak_buku;
    }

    public void setRak_buku(String rak_buku) {
        this.rak_buku = rak_buku;
    }

    public String getRak_baris_buku() {
        return rak_baris_buku;
    }

    public void setRak_baris_buku(String rak_baris_buku) {
        this.rak_baris_buku = rak_baris_buku;
    }
}
