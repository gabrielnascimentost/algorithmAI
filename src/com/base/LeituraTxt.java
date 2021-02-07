package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeituraTxt {

    public Grafo lerArquivoTxt(){
        Grafo g = new Grafo();
        List<No> listaNos = new ArrayList<>();
        try {
            File arquivo = new File("../files/grafo.txt");
            FileInputStream entrada = new FileInputStream(arquivo);
            Scanner scanner = new Scanner(entrada);
            String qntPossibilidades = scanner.nextLine();
            for(int i = 0; i < Integer.parseInt(qntPossibilidades); i++){
                No no = new No();
                no.descicao = scanner.next();
                no.heuristica = Integer.parseInt(scanner.next());
                listaNos.add(no);
            }

            while (scanner.hasNext()){
                int origem = Integer.parseInt(scanner.next());
                int destino = Integer.parseInt(scanner.next());
                int distancia = Integer.parseInt(scanner.next());
                listaNos.get(origem).addCaminho(listaNos.get(destino), distancia);
            }

        }catch (FileNotFoundException ex){
            Logger.getLogger(LeituraTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  g;
    }
}
