package com.example.meuuniversomarvel.util;

import java.util.ArrayList;

public class AppJogoUtils {

    private ArrayList<Integer> numerosRandom = new ArrayList<>();
    private int numAtual;
    private int qtdeErros;
    private int qtdeNumAcertos;

    public ArrayList<Integer> getNumerosRandom() {
        return numerosRandom;
    }

    public void setNumerosRandom(ArrayList<Integer> numerosRandom) {
        this.numerosRandom = numerosRandom;
    }

    public int getNumAtual() {
        return numAtual;
    }

    public void setNumAtual(int numAtual) {
        this.numAtual = numAtual;
    }

    public int getQtdeErros() {
        return qtdeErros;
    }

    public void setQtdeErros(int qtdeErros) {
        this.qtdeErros = qtdeErros;
    }

    public int getQtdeNumAcertos() {
        return qtdeNumAcertos;
    }

    public void setQtdeNumAcertos(int qtdeNumAcertos) {
        this.qtdeNumAcertos = qtdeNumAcertos;
    }
}
