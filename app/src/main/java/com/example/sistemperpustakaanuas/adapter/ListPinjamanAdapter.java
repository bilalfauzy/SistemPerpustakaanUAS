package com.example.sistemperpustakaanuas.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemperpustakaanuas.R;
import com.example.sistemperpustakaanuas.activity.DetailBukuActivity;
import com.example.sistemperpustakaanuas.modeldata.DataBuku;

import java.util.List;

public class ListPinjamanAdapter extends RecyclerView.Adapter<ListPinjamanAdapter.MyViewHolder> {
    private List<DataBuku> listBukuPinjaman;
    private Context context;

    public ListPinjamanAdapter(List<DataBuku> mListBukuPinjaman, Context mContext){
        listBukuPinjaman = mListBukuPinjaman;
        context = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_buku, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataBuku dataBuku = listBukuPinjaman.get(position);
        holder.imgBuku.setImageResource(R.drawable.ic_baseline_book_24);
        holder.imgArrow.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24);

        holder.tvJudulBuku.setText("Judul : " +dataBuku.getJudul_buku());
        holder.tvPenulis.setText("Penulis : " +dataBuku.getPenulis_buku());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailBukuActivity.class);
                view.getContext().startActivity(intent
                        .putExtra("sampul_buku", dataBuku.getSampul_buku())
                        .putExtra("judul_buku", dataBuku.getJudul_buku())
                        .putExtra("penulis", dataBuku.getPenulis_buku())
                        .putExtra("penerbit", dataBuku.getPenerbit_buku())
                        .putExtra("kategori", dataBuku.getKategori_buku())
                        .putExtra("stok_buku", dataBuku.getStok_buku()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBukuPinjaman.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvJudulBuku, tvPenerbit, tvKategori, tvPenulis;
        public ImageView imgBuku, imgArrow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJudulBuku = itemView.findViewById(R.id.tvJudul);
            tvPenerbit = itemView.findViewById(R.id.tvPenerbit);
            tvPenulis = itemView.findViewById(R.id.tvPenulis);
            tvKategori = itemView.findViewById(R.id.tvKategori);
            imgBuku = itemView.findViewById(R.id.imgBuku);
            imgArrow = itemView.findViewById(R.id.imgArrow);
        }
    }
}
