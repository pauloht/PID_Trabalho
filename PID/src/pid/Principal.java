/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pid;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FREE
 */
public class Principal {
    public static void subDividir(ArrayList<Cor> lista,int vezes)
    {
        No raiz = new No(lista);
        List< No > listaDeNos = new ArrayList<>();
        
        int posicaoContador = 0;
        
        listaDeNos.add(raiz);
        
        int posComeco = 0;
        int posFim = 0;
        
        int aux;
        
        for (int i=0;i<vezes;i++){
            aux = posicaoContador;
            for (int j=posComeco;j<=posFim;j++){
                No noLocal = listaDeNos.get(j);
                noLocal.subdividir();
                posicaoContador++;
                listaDeNos.add(noLocal.getEsquerda());
                posicaoContador++;
                listaDeNos.add(noLocal.getDireita());
            }
            posComeco = aux+1;
            posFim = posicaoContador;
        }
        
        int contador = 0;
        for (No no : listaDeNos){
            System.out.println("Subnivel " + contador + ":" + no.getLista());
            contador++;
        }
    }
}
