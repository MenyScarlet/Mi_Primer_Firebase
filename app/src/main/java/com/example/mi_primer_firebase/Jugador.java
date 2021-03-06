package com.example.mi_primer_firebase;

/**
 * Created by Melania on 23/02/2018.
 */

public class Jugador {

    String nombre;
    int dorsal;
    String posicion;
    double  sueldo;

    public Jugador() {
    }

    public Jugador(String nombre, int dorsal, String posicion, double sueldo) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
