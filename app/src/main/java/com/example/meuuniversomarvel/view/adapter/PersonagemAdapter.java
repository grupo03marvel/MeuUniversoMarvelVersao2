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
import com.example.meuuniversomarvel.view.interfaces.FavoriteItemAddClick;
import com.example.meuuniversomarvel.view.interfaces.PersonagensOnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

    public class PersonagemAdapter extends RecyclerView.Adapter <PersonagemAdapter.ViewHolder> {
        private List<Result> resultList;
        private PersonagensOnClick listener;
        private FavoriteItemAddClick addClick;

        public PersonagemAdapter(List<Result> resultList, PersonagensOnClick listener, FavoriteItemAddClick addClick) {
            this.resultList = resultList;
            this.listener = listener;
            this.addClick = addClick;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cecycler_personagem, parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Result result = resultList.get(position);
            holder.onBind(result);

            holder.addItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addClick.addFavoriteClickListener(result);
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.personagemOnClick(result);
                }
            });

        }

        @Override
        public int getItemCount() {
            return resultList.size();
        }

        public void atualizaListaP(List<Result> novaLista){
            if (this.resultList.isEmpty()){
                this.resultList = novaLista;
            }else {
                this.resultList.addAll(novaLista);
            }

            notifyDataSetChanged();
        }



        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView nomePerso;
            private ImageView fotoPerso;
            private ImageView addItem;



            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nomePerso = itemView.findViewById(R.id.nomeItem);
                fotoPerso = itemView.findViewById(R.id.imgItem);
                addItem = itemView.findViewById(R.id.salvarFavorito);
            }

            public void onBind(Result result) {
                Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(fotoPerso);

                nomePerso.setText(result.getName());

            }
        }
    }
