package com.company;

public class Adjacencia {
    private int dist;
    private No prox;

    public Adjacencia(int dist, No prox) {
        this.dist = dist;
        this.prox = prox;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
