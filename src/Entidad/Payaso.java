/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;

/**
 *
 * @author esnip
 */
public class Payaso implements Serializable{
    private String apodo;
    private String circo;
    private int nivelDeComedia;

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getCirco() {
        return circo;
    }

    public void setCirco(String circo) {
        this.circo = circo;
    }

    public int getNivelDeComedia() {
        return nivelDeComedia;
    }

    public void setNivelDeComedia(int nivelDeComedia) {
        this.nivelDeComedia = nivelDeComedia;
    }
    public String toString(){
        return "Payaso [Apodo del payaso: "+apodo+ " Circo donde trabaja: "+circo+" Nivel de comedia del payaso: "+nivelDeComedia+" ]";
    }
}
