package com.example.sistemperpustakaanuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemperpustakaanuas.ClickListener;
import com.example.sistemperpustakaanuas.R;
import com.example.sistemperpustakaanuas.modeldata.DataBuku;

import java.lang.ref.WeakReference;
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
        holder.imgArrow.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24);

        holder.tvJudulBuku.setText("Judul : " +dataBuku.getJudul_buku());
        holder.tvPenulis.setText("Penulis : " +dataBuku.getPenulis_buku());
        holder.tvPenerbit.setText("Penerbit : " +dataBuku.getPenerbit_buku());
        holder.tvKategori.setText("Kategori : " +dataBuku.getKategori_buku());

        holder.itemView.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public int getItemCount() {
        return listDataBuku.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvJudulBuku, tvPenerbit, tvKategori, tvPenulis;
        public ImageView imgBuku, imgArrow;
        private WeakReference<ClickListener> listenerRef;

        public MyViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);

            listenerRef = new WeakReference<>(ListBukuAdapter.this.clickListener);

            tvJudulBuku = itemView.findViewById(R.id.tvJudul);
            tvPenerbit = itemView.findViewById(R.id.tvPenerbit);
            tvPenulis = itemView.findViewById(R.id.tvPenulis);
            tvKategori = itemView.findViewById(R.id.tvKategori);
            imgBuku = itemView.findViewById(R.id.imgBuku);
            imgArrow = itemView.findViewById(R.id.imgArrow);
        }

        @Override
        public void onClick(View view) {
            listenerRef.get().onPositionClicked(getAdapterPosition());
        }
    }
}
