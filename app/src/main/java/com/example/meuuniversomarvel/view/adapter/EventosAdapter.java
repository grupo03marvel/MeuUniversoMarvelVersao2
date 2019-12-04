package com.example.meuuniversomarvel.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuuniversomarvel.R;
import com.example.meuuniversomarvel.model.events.ResultEvents;
import com.example.meuuniversomarvel.view.interfaces.EventosOnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventosAdapter extends RecyclerView.Adapter<EventosAdapter.ViewHolder> {
    private List<ResultEvents> resultList;
    private EventosOnClick listener;

    public EventosAdapter(List<ResultEvents> resultEventsList, EventosOnClick listener) {
        this.resultList = resultEventsList;
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
        final ResultEvents result = resultList.get(position);
        holder.onBind(result);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.eventosOnClick(result);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void atualizaListaE(List<ResultEvents> novaLista){
        if (this.resultList.isEmpty()){
            this.resultList = novaLista;
        }else {
            this.resultList.addAll(novaLista);
        }

        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nomeEvento;
        private ImageView imagemEvento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeEvento = itemView.findViewById(R.id.nomeItem);
            imagemEvento = itemView.findViewById(R.id.imgItem);
        }

        public void onBind(ResultEvents resultEvents) {
            Picasso.get().load(resultEvents.getThumbnail().getPath() + ".jpg").into(imagemEvento);

            nomeEvento.setText(resultEvents.getTitle());


        }
    }
}