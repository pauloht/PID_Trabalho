/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author FREE
 */
public class No {
    private No esquerda = null;
    private No direita = null;
    private No pai = null;
    private char tipoDivisao = ' ';
    private ArrayList< Cor > cores = null;
    
    public No(ArrayList<Cor> cores,No pai){
        this.cores = cores;
        this.pai = pai;
    }
    
    public void subdividir(){
        if (esquerda==null && direita==null){
            Cmp comparador = null;
            char tipo = ' ';
            Cor dif = Cor.difDosCanais(cores);
            if (dif.getU()>=dif.getV()){
                tipo='U';
                comparador = new Cmp(CmpEnum.UMAIOR);
            }else{
                tipo='V';
                comparador = new Cmp(CmpEnum.VMAIOR);
            }
            tipoDivisao = tipo;
            Collections.sort(cores,comparador);
            ArrayList<Cor> listaEsqueda = Cor.gerarSubVetor(cores, 'E', tipo);
            ArrayList<Cor> listaDireita = Cor.gerarSubVetor(cores, 'D', tipo);

            esquerda = new No(listaEsqueda,this);
            direita = new No(listaDireita,this);
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
    
    public No getPai(){
        return(pai);
    }
    
    public char tipoDiv(){
        return(tipoDivisao);
    }
}
