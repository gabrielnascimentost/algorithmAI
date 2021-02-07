package com.base;

import java.util.LinkedHashMap;

public class No {
    public String descicao;
    public int heuristica;
    public LinkedHashMap<String, Adjacencia> adjacencias;
    public boolean ehSolucao;
    public No antecessor;
    public No no;

    public No() {
        adjacencias = new LinkedHashMap<>();
        ehSolucao = false;
        antecessor = null;
    }

    public No(String descicao, No antecessor) {
        this.descicao = descicao;
        this.antecessor = antecessor;
        ehSolucao = false;
        adjacencias = new LinkedHashMap<>();
    }

    public No(String descicao) {
        this.descicao = descicao;
        this.antecessor = null;
        ehSolucao = false;
        adjacencias = new LinkedHashMap<>();
    }

    public No(String descicao, int heuristica) {
        this.descicao = descicao;
        this.heuristica = heuristica;
        ehSolucao = false;
        adjacencias = new LinkedHashMap<>();
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public int getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(int heuristica) {
        this.heuristica = heuristica;
    }

    public LinkedHashMap<String, Adjacencia> getAdjacencias() {
        return adjacencias;
    }

    public void setAdjacencias(LinkedHashMap<String, Adjacencia> adjacencias) {
        this.adjacencias = adjacencias;
    }

    public boolean isEhSolucao() {
        return ehSolucao;
    }

    public void setEhSolucao(boolean ehSolucao) {
        this.ehSolucao = ehSolucao;
    }

    public No getAntecessor() {
        return antecessor;
    }

    public void setAntecessor(No antecessor) {
        this.antecessor = antecessor;
    }

    public No getNo() {
        return no;
    }

    public void setNo(No no) {
        this.no = no;
    }

    public boolean addCaminho(No auxNo, int dist){
        if (adjacencias.containsKey(auxNo.descicao)) {
            return false;
        }

        adjacencias.put(auxNo.descicao, new Adjacencia(dist, auxNo));
        return true;
    }

    @Override
    public String toString() {
        return "No{" +
                "descicao='" + descicao + '\'' +
                '}';
    }
}
