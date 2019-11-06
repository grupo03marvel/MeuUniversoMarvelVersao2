package com.example.meuuniversomarvel.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.viewmodel.ItemHome;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<ItemHome> listaItens;

    public ItemAdapter(List<ItemHome> listaItens) {
        this.listaItens = listaItens;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_categoria, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemHome itemHome = listaItens.get(position);

        holder.bind(itemHome);
    }

    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    //Criando ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        //declarando atributos
        private ImageView imgItem;
        private TextView nomeItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            nomeItem = itemView.findViewById(R.id.nomeItem);

        }

        public void bind(ItemHome itemhome){
            imgItem.setImageDrawable(ContextCompat.getDrawable(imgItem.getContext(), itemhome.getImagemItemHome()));
            nomeItem.setText(itemhome.getNomeItemHome());
        }

    }
}
