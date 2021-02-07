package com.base;

public class NoPonderado {
    public NoPonderado ant;
    public No no;
    public int custoTotal;
    public int valorHeuristico;

    public NoPonderado(NoPonderado ant, No no, int custoTotal) {
        this.ant = ant;
        this.no = no;
        this.custoTotal = custoTotal;
    }

    public NoPonderado(NoPonderado ant, No no, int custoTotal, int valorHeuristico) {
        this.ant = ant;
        this.no = no;
        this.custoTotal = custoTotal;
        this.valorHeuristico = valorHeuristico;
    }
}
