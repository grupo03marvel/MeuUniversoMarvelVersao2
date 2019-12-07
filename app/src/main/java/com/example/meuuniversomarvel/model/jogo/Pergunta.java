
package com.example.meuuniversomarvel.model.jogo;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Pergunta {

    @Expose
    private String correta;
    @Expose
    private String imagem;
    @Expose
    private List<Resposta> respostas;
    @Expose
    private String texto;

    public String getCorreta() {
        return correta;
    }

    public void setCorreta(String correta) {
        this.correta = correta;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
