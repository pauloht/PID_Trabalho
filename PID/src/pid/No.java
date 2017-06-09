/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pid;

import java.util.ArrayList;

/**
 *
 * @author FREE
 */
public class No {
    private No esquerda = null;
    private No direita = null;
    private ArrayList< Cor > cores = null;
    
    public No(ArrayList<Cor> cores){
        this.cores = cores;
    }
    
    public void subdividir(){
        if (esquerda==null && direita==null){
            char tipo = ' ';
            Cor dif = Cor.difDosCanais(cores);
            if (dif.getU()>=dif.getV()){
                tipo='U';
            }else{
                tipo='V';
            }
            ArrayList<Cor> listaEsqueda = Cor.gerarSubVetor(cores, 'E', tipo);
            ArrayList<Cor> listaDireita = Cor.gerarSubVetor(cores, 'D', tipo);

            esquerda = new No(listaEsqueda);
            direita = new No(listaDireita);
        }else{
            throw new IllegalStateException("Ja foi subdividido");
        }
    }
    
    public No getDireita(){
        return(direita);
    }
    
    public No getEsquerda(){
        return(esquerda);
    }
    
    public ArrayList getLista(){
        return(cores);
    }
}
