
package com.example.meuuniversomarvel.model.jogo;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Resposta {

    @Expose
    private String a;
    @Expose
    private String b;
    @Expose
    private String c;
    @Expose
    private String d;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

}
