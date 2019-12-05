package com.example.meuuniversomarvel.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.characters.Result;
import com.example.meuuniversomarvel.view.interfaces.PersonagensOnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ViewHolder> {

    private List<Result> favoritosList;
    private PersonagensOnClick onClick;

    public FavoritosAdapter(List<Result> favoritosList, PersonagensOnClick onClick) {
        this.favoritosList = favoritosList;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_categoria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result favoritos = favoritosList.get(position);
        holder.onBind(favoritos);

        holder.itemView.setOnClickListener(view -> {
            onClick.personagemOnClick(favoritos);
        });

    }

    @Override
    public int getItemCount() {
        return favoritosList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewFavorite;
        private TextView textNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFavorite = itemView.findViewById(R.id.btnImageFavoritos);
            textNome = itemView.findViewById(R.id.textViewTitulo);
        }


        public void onBind(Result favoritos) {

            if (favoritos.getThumbnail().getPath() != null && favoritos.getThumbnail().getExtension() != null) {
                Picasso.get().load(favoritos.getThumbnail().getPath() + "/portrait_incredible." +
                        favoritos.getThumbnail().getExtension())
                        .into(imageViewFavorite);
            }

            if (favoritos.getName() != null) {
                textNome.setText(favoritos.getName());
            } else {
                textNome.setText("");
            }
        }
    }


    public void atualizaLista(List<Result> novaLista) {
        if (this.favoritosList.isEmpty()) {
            this.favoritosList = novaLista;
        } else {
            this.favoritosList.addAll(novaLista);
        }
        notifyDataSetChanged();
    }


}
