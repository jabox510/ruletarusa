package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ruletaRusa {
    private List<Integer> tambor;
    private int bala;
    private int posicion_actual;
    private Random random;
    private List<String> jugadores;
    private int turno_actual;


    public ruletaRusa(int num_jugadores, List<String> nombres) {
        this.random = new Random();
        this.jugadores = nombres;
        this.turno_actual = 0;
        reiniciar_juego();
    }


    public boolean disparar() {
        boolean resultado = (posicion_actual == bala);
        setPosicion_actual((posicion_actual + 1) % tambor.size());
        return resultado;
    }


    public void reiniciar_juego() {
        tambor = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tambor.add(i);
        }
        setBala(random.nextInt(tambor.size()));
        setPosicion_actual(0);
        setTurno_actual(0);
    }

    public void mostrar_informacion() {
        System.out.println(" TAMBOR:");
        System.out.println("UBICACION DE LA BALA: " + bala);
        System.out.println("RECAMARA ACTUAL: " + posicion_actual);
    }


    public int getPosicion_actual() {
        return posicion_actual;
    }

    public void setPosicion_actual(int posicion_actual) {
        this.posicion_actual = posicion_actual;
    }

    public int getBala() {
        return bala;
    }

    public void setBala(int bala) {
        this.bala = bala;
    }

    public int getTurno_actual() {
        return turno_actual;
    }

    public void setTurno_actual(int turno_actual) {
        this.turno_actual = turno_actual;
    }

    public String getJugador_actual() {
        return jugadores.get(turno_actual);
    }

    public void siguiente_turno() {
        setTurno_actual((turno_actual + 1) % jugadores.size());
    }
}