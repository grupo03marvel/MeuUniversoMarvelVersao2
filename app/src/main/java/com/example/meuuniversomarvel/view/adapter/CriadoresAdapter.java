package com.example.meuuniversomarvel.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.creators.Result;
import com.example.meuuniversomarvel.view.interfaces.CriadoresOnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CriadoresAdapter extends RecyclerView.Adapter<CriadoresAdapter.ViewHolder> {
    private List<Result> resultList;
    private CriadoresOnClick listener;

    public CriadoresAdapter(List<Result> resultList, CriadoresOnClick listener) {
        this.resultList = resultList;
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
        final Result result = resultList.get(position);
        holder.onBind(result);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.criadoresOnClick(result);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void atualizaListaC(List<Result> novaLista){
        if (this.resultList.isEmpty()){
            this.resultList = novaLista;
        }else {
            this.resultList.addAll(novaLista);
        }

        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeCriador;
        private ImageView fotoCriador;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeCriador = itemView.findViewById(R.id.nomeItem);
            fotoCriador = itemView.findViewById(R.id.imgItem);
        }

        public void onBind(Result result) {
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(fotoCriador);

            nomeCriador.setText(result.getFullName());

        }
    }
}
