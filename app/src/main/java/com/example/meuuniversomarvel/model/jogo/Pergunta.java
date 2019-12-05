
package com.example.meuuniversomarvel.model.jogo;

import java.util.List;

public class Pergunta {

    private List<Perguntum> pergunta;
    private List<Pergunta> perguntas;

    public List<Perguntum> getPergunta() {
        return pergunta;
    }

    public void setPergunta(List<Perguntum> pergunta) {
        this.pergunta = pergunta;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

}
