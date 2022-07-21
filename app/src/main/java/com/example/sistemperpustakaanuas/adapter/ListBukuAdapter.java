package com.example.sistemperpustakaanuas.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemperpustakaanuas.ClickListener;
import com.example.sistemperpustakaanuas.R;
import com.example.sistemperpustakaanuas.activity.BukuDipinjamActivity;
import com.example.sistemperpustakaanuas.activity.DetailBukuActivity;
import com.example.sistemperpustakaanuas.activity.ListBukuActivity;
import com.example.sistemperpustakaanuas.modeldata.DataBuku;

import java.lang.ref.WeakReference;
import java.text.BreakIterator;
import java.util.List;

public class ListBukuAdapter extends RecyclerView.Adapter<ListBukuAdapter.MyViewHolder>{
    private List<DataBuku> listDataBuku;
    private Context context;
    private final ClickListener clickListener;

    public ListBukuAdapter(List<DataBuku> mListDataBuku, Context mContext, ClickListener mClickListener){
        listDataBuku = mListDataBuku;
        context = mContext;
        clickListener = mClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_buku, parent, false), clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataBuku dataBuku = listDataBuku.get(position);

        holder.imgBuku.setImageResource(R.drawable.ic_baseline_book_24);
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
        return listDataBuku.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvJudulBuku, tvPenerbit, tvKategori, tvPenulis;
        public ImageView imgBuku;
        public Button btnPinjam;
        private WeakReference<ClickListener> listenerRef;

        public MyViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);

            listenerRef = new WeakReference<>(clickListener);
            tvJudulBuku = itemView.findViewById(R.id.tvJudul);
            tvPenerbit = itemView.findViewById(R.id.tvPenerbit);
            tvPenulis = itemView.findViewById(R.id.tvPenulis);
            tvKategori = itemView.findViewById(R.id.tvKategori);
            imgBuku = itemView.findViewById(R.id.imgBuku);
            btnPinjam = itemView.findViewById(R.id.btnPinjam);

            btnPinjam = itemView.findViewById(R.id.btnPinjam);
            btnPinjam.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == btnPinjam.getId()){
                Toast.makeText(view.getContext(), "Dipinjam", Toast.LENGTH_SHORT).show();
            }
            listenerRef.get().onPositionClicked(getAdapterPosition());
        }
    }
}
