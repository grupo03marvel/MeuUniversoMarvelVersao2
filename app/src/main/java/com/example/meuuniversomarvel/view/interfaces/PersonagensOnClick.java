package com.example.meuuniversomarvel.view.interfaces;

import com.example.meuuniversomarvel.model.characters.Result;

public interface PersonagensOnClick {

    void personagemOnClick(Result result);

    void addFavoriteClickListener(Result result);

    void removeFavoriteClickListener(Result result);
}
