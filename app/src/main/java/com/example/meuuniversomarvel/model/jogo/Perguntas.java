
package com.example.meuuniversomarvel.model.jogo;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Perguntas {

    @Expose
    private List<Pergunta> perguntas;

    public List<Pergunta> getPergunta() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

}
