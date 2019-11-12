package com.example.meuuniversomarvel.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.comics.Image;
import com.example.meuuniversomarvel.model.comics.Item;
import com.example.meuuniversomarvel.view.interfaces.OnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HqAdapter extends RecyclerView.Adapter<HqAdapter.ViewHolder> {

    private List<Item> hqsList;
    private OnClick listener;

    public HqAdapter(List<Item> hqsList, OnClick listener) {
        this.hqsList = hqsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_categoria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = hqsList.get(position);
        Image imagem = hqsList.get(position);
        holder.onBind(item, imagem);

        holder.itemView.setOnClickListener(v -> listener.click(item, imagem));
    }

    @Override
    public int getItemCount() {
        return hqsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.imgItem);
            textView = itemView.findViewById(R.id.nomeItem);
        }

        public void onBind(Item item, Image imagem){
            textView.setText(item.getName());

            Picasso.get().load("http://i.annihil.us/u/prod/marvel/i/mg/"+imagem.getPath()).into(imageView);
        }

    }
}
