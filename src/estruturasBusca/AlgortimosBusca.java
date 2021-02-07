package estruturasBusca;

import com.base.Adjacencia;
import com.base.No;
import com.base.NoPonderado;

import java.util.LinkedHashMap;
import java.util.LinkedList;

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
