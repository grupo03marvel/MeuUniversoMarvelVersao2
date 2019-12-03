package com.example.meuuniversomarvel.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.characters.ResultCharacters;
import com.example.meuuniversomarvel.view.interfaces.PersonagensOnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

    public class PersonagemAdapter extends RecyclerView.Adapter <PersonagemAdapter.ViewHolder> {
        private List<ResultCharacters> resultList;
        private PersonagensOnClick listener;

        public PersonagemAdapter(List<ResultCharacters> resultCharactersList, PersonagensOnClick listener) {
            this.resultList = resultCharactersList;
            this.listener = listener;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_categoria, parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final ResultCharacters result = resultList.get(position);
            holder.onBind(result);

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

        public void atualizaListaP(List<ResultCharacters> novaLista){
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



            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nomePerso = itemView.findViewById(R.id.nomeItem);
                fotoPerso = itemView.findViewById(R.id.imgItem);
            }

            public void onBind(ResultCharacters resultCharacters) {
                Picasso.get().load(resultCharacters.getThumbnail().getPath() + ".jpg").into(fotoPerso);

                nomePerso.setText(resultCharacters.getName());

            }
        }
    }
