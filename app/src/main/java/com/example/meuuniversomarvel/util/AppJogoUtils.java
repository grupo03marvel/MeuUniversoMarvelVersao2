package com.example.meuuniversomarvel.util;

import java.util.ArrayList;

public class AppJogoUtils {

    private ArrayList<Integer> numerosRandom = new ArrayList<>();
    private int numAtual;
    private static int qtdeNumErros;
    private static int qtdeNumAcertos;

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
        return qtdeNumErros;
    }

    public void setQtdeErros(int qtdeErros) {
        this.qtdeNumErros = qtdeErros;
    }

    public int getQtdeNumAcertos() {
        return qtdeNumAcertos;
    }

    public void setQtdeNumAcertos(int qtdeNumAcertos) {
        this.qtdeNumAcertos = qtdeNumAcertos;
    }

    public static int pegarAcertos(){
        return qtdeNumAcertos;
    }

    public static int pegarErros(){
        return qtdeNumErros;
    }

    public static void setAcertos(int qtdeAcertos){
        qtdeNumAcertos = qtdeAcertos;
    }

    public static void setErros(int qtdeErros){
        qtdeNumErros = qtdeErros;
    }
}
