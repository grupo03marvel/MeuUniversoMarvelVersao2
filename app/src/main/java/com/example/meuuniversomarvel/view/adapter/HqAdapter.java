
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
import com.example.meuuniversomarvel.model.comics.Result;
import com.example.meuuniversomarvel.view.interfaces.HqsOnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HqAdapter extends RecyclerView.Adapter<HqAdapter.ViewHolder> {
    private List<Result> hqsList;
    private List<Image> hqsListImagem;
    private HqsOnClick listener;

    public HqAdapter(List<Result> hqsList, HqsOnClick listener) {
        this.hqsList = hqsList;
        this.listener = listener;
    }

    public HqAdapter(List<Result> hqsList) {
        this.hqsList = hqsList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_categoria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = hqsList.get(position);
        holder.onBind(result);

        holder.itemView.setOnClickListener(v -> listener.click(result));
    }

    @Override
    public int getItemCount() {
        return hqsList.size();
    }


    public void atualizaLista(List<Result> novaLista){
        if (this.hqsList.isEmpty()){
            this.hqsList = novaLista;
        }else {
            this.hqsList.addAll(novaLista);
        }
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.imgItem);
            textView = itemView.findViewById(R.id.nomeItem);
        }

        public void onBind(Result result){
            textView.setText(result.getTitle());

            Picasso.get().load(result.getThumbnail().getPath()+ ".jpg").into(imageView);
        }

    }
}

