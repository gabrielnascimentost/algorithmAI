package estruturasBusca;

import com.base.Adjacencia;
import com.base.No;
import com.base.NoPonderado;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;

public class AlgortimosBusca {

    public static void buscaLargura(No origem, No destino){
        System.out.println("\n Iniciando Busca em Largura...");
        LinkedList<NoPonderado> abertos = new LinkedList<>();
        LinkedList<No> abertosGeral = new LinkedList<>();
        LinkedHashMap<String, No> nosVisitados = new LinkedHashMap<>();

        abertos.add(new NoPonderado(null, origem, 0));
        abertosGeral.add(origem);

        boolean ehSolucao = false;
        int numInteracoes = 0;
        NoPonderado estadoFinal = null;

        while (!ehSolucao){
            if(abertos.isEmpty()){
                ehSolucao = false;
                break;
            } else {
                NoPonderado auxNo = abertos.removeFirst();
                System.out.println("\nRota " + auxNo.no.descicao);
                nosVisitados.put(auxNo.no.descicao, auxNo.no);
                if (auxNo.no.descicao.equals(destino.descicao)){
                    ehSolucao = true;
                    estadoFinal = auxNo;
                    break;
                }else{
                    for(Adjacencia auxAdj : auxNo.no.adjacencias.values()){
                        No auxProx = auxAdj.getProx();
                        if(!nosVisitados.containsKey(auxProx.descicao)){
                            System.out.println(auxNo.no.descicao + ">> " + auxProx.descicao);
                            abertos.add(new NoPonderado(auxNo, auxProx, auxNo.custoTotal + auxAdj.getDist()));
                            abertosGeral.add(auxProx);
                        }
                    }
                }
                numInteracoes++;
            }
        }

        if(ehSolucao){
            System.out.println("Solucao encontrada com " + numInteracoes + "interacoes");
            impressao(nosVisitados, abertosGeral, estadoFinal);
        }else {
            System.out.println("Solucao nao encontrada. " + numInteracoes + "interacoes");
        }
    }

    public static void buscaBacktracking(No origem, No destino) {
        System.out.println("Iniciando busca backtracking");
        HashMap<String, No> nosVisitados = new HashMap<>();
        Stack<No> percurso = new Stack<>();
        int custoCaminho = 0;
        int numInteracoes = 0;
        boolean ehSolucao = false;

        percurso.push(origem);
        nosVisitados.put(origem.descicao, origem);
        while (!ehSolucao) {
            boolean noInserido = false;

            if(percurso.isEmpty()){
                ehSolucao = false;
                break;
            }else{
                No auxNo = percurso.peek();
                if(auxNo.descicao.equals(destino.descicao)){
                    ehSolucao = true;
                    break;
                } else{
                    for (Adjacencia auxAdj : auxNo.adjacencias.values()){
                        System.out.println(auxNo.descicao + " >> " + auxAdj.getProx().descicao);
                    }
                    for (Adjacencia adj : auxNo.adjacencias.values()) {
                        No auxProx = adj.getProx();
                        if (!nosVisitados.containsKey(auxProx.descicao)) {
                            noInserido = true;
                            percurso.push(auxProx);
                            nosVisitados.put(auxProx.descicao, auxProx);
                            custoCaminho = custoCaminho + adj.getDist();
                            break;
                        }
                    }
                }
                numInteracoes++;
                if (!noInserido) {
                    percurso.pop();
                }
            }
        }
        if(ehSolucao){
            System.out.println("\nCaminho:");
            for (No auxNo : percurso) {
                System.out.print("[" + auxNo.descicao + "] ");
            }
            System.out.println("\n\nSolucao encontrada com " + numInteracoes + " iteracoes.\n\n Custo do percurso: " + custoCaminho);
        }
    }

    public static void impressao(LinkedHashMap<String, No> nosVisitados, LinkedList<No> listAbertos, NoPonderado estadoFinal){
        int auxCustoTotal = estadoFinal.custoTotal;
        System.out.println("\nNós abertos: ");
        for(No aberto : listAbertos){
            System.out.print("[" + aberto.descicao + "]");
        }
        System.out.println("\nNós visitados: ");
        for(No aberto : nosVisitados.values()){
            System.out.print("[" + aberto.descicao + "]");
        }
        System.out.println("\nSolução encontrada: ");
        while (estadoFinal != null){
            System.out.print("[" + estadoFinal.no + "]");
            estadoFinal = estadoFinal.ant;
        }
        System.out.println("Custo da solucao: " + auxCustoTotal);
    }

}
