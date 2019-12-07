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
import com.example.meuuniversomarvel.view.interfaces.FavoriteItemRemoveClick;
import com.example.meuuniversomarvel.view.interfaces.PersonagensOnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ViewHolder> {

    private List<Result> favoritosList;
    private PersonagensOnClick onClick;
    private FavoriteItemRemoveClick removeClick;

    public FavoritosAdapter(List<Result> favoritosList, PersonagensOnClick onClick, FavoriteItemRemoveClick removeClick) {
        this.favoritosList = favoritosList;
        this.onClick = onClick;
        this.removeClick = removeClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cecycler_personagem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result favoritos = favoritosList.get(position);
        holder.onBind(favoritos);

        holder.itemView.setOnClickListener(view -> {
            onClick.personagemOnClick(favoritos);
        });

        holder.removetem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeClick.removeFavoriteClickListener(favoritos);
            }
        });

    }

    @Override
    public int getItemCount() {
        return favoritosList.size();
    }

    public void update(List<Result> results) {
        this.favoritosList = results;
        notifyDataSetChanged();
    }

    public void removeItem(Result result){
        favoritosList.remove(result);
        notifyDataSetChanged();
    }



        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView nomePerso;
            private ImageView fotoPerso;
            private ImageView removetem;



            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nomePerso = itemView.findViewById(R.id.nomeItem);
                fotoPerso = itemView.findViewById(R.id.imgItem);
                removetem = itemView.findViewById(R.id.salvarFavorito);
            }

            public void onBind(Result result) {
                Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(fotoPerso);

                nomePerso.setText(result.getName());

            }
        }
    }
