package com.fer.aula15_recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    Context context;
    ItemData[] itemData;
    boolean escuro;

    public ItemAdapter(Context context, ItemData[] itemData, boolean escuro) {
        this.context = context;
        this.itemData = itemData;
        this.escuro = escuro;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.data.setText(itemData[position].getData());
        holder.nome.setText(itemData[position].getNome());
        holder.imageView.setImageResource(itemData[position].getImgId());
    }

    @Override
    public int getItemCount() {
        return itemData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome, data;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
            data = itemView.findViewById(R.id.data);
            if(escuro){
                nome.setTextColor(Color.WHITE);
                data.setTextColor(Color.WHITE);
            }
            imageView = itemView.findViewById(R.id.imagem00);
        }
    }
}
