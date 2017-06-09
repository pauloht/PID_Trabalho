/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author FREE
 */
public class Principal {
    public static void subDividir(ArrayList<Cor> lista,int vezes)
    {
        No raiz = new No(lista,null);
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
        System.out.println("---------------------------------");
        for (No no : listaDeNos){
            ArrayList listaLocal = no.getLista();
            No pai = no.getPai();
            System.out.println("Subnivel " + contador + ":");
            if (pai!=null){
                if (pai.tipoDiv()=='U'){
                    Collections.sort(pai.getLista(),new Cmp(CmpEnum.UMAIOR));
                }else if(pai.tipoDiv()=='V'){
                    Collections.sort(pai.getLista(),new Cmp(CmpEnum.VMAIOR));
                }else{
                    throw new UnknownError();
                }
                if (pai.getEsquerda()==no){
                    System.out.println("Filho esquerdo de :" + pai.getLista());
                }else{
                    System.out.println("Filho direito de :" + pai.getLista());
                }
            }else{
                System.out.println("Nó raiz");
            }
            System.out.println("Antes de ordenador : " + listaLocal);
            System.out.println("Dif : " + Cor.difDosCanais(listaLocal));
            if (pai!=null){
                if (pai.tipoDiv()=='U'){
                    Collections.sort(listaLocal,new Cmp(CmpEnum.UMAIOR));
                    System.out.println("Ordenado por U : " + listaLocal);
                }else{
                    Collections.sort(listaLocal,new Cmp(CmpEnum.VMAIOR));
                System.out.println("Ordenado por V : " + listaLocal);
                }
            }else{
                Collections.sort(listaLocal,new Cmp(CmpEnum.UMAIOR));
                System.out.println("Ordenado por U : " + listaLocal);
                Collections.sort(listaLocal,new Cmp(CmpEnum.VMAIOR));
                System.out.println("Ordenado por V : " + listaLocal);
            }
            System.out.println("Cor media : " + Cor.getNovaCor(listaLocal));
            contador++;
            System.out.println("---------------------------------");
        }
    }
}
