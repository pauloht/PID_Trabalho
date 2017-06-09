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
public class Cor{
    private int u;
    private int v;
    
    public int getU()
    {
        return(u);
    }
    
    public int getV()
    {
        return(v);
    }

    public Cor(int u,int v){
        this.u = u;
        this.v = v;
    }
    
    @Override
    public String toString() {
        return "[" + u + "," + v + ']';
    }
    
    public static Cor difDosCanais(ArrayList<Cor> lista)
    {
        int menorU=0,maiorU=0,maiorV=0,menorV=0;
        boolean comeco = true;
        for (Cor corLocal : lista){
            if (comeco){
                comeco = false;
                menorU = corLocal.getU();
                maiorU = menorU;
                menorV = corLocal.getV();
                maiorV = menorV;
            }else{
                int localU = corLocal.getU();
                int localV = corLocal.getV();
                
                if (localU<menorU){
                    menorU = localU;
                }
                if (localU>maiorU){
                    maiorU = localU;
                }
                if (localV<menorV){
                    menorV = localV;
                }
                if (localV>maiorV){
                    maiorV = localV;
                }
            }
        }
        return(new Cor((maiorU-menorU),(maiorV-menorV)));
    }
    
    /**
     * 
     * @param vetorOriginal
     * @param tipo se tipo igual a 'D' gera subvetor para direita da mediana se 'E' gera subvetor a esquerda
     * @param ordenadoPor pode ser 'U' ou 'V'
     * @return 
     */
    public static ArrayList gerarSubVetor(ArrayList<Cor> vetorOriginal,char tipo,char ordenadoPor){
        ArrayList< Cor > retorno = new ArrayList<>();
        
        int tamanho = vetorOriginal.size();
        int pivo = 0;
        
        if (tamanho%2==0){ //se é PAR
            if (tipo=='D'){
                pivo = ((tamanho+2)/2);
            }else if (tipo=='E'){
                pivo = ((tamanho)/2);
            }
        }else{ //se é IMPAR
            pivo = (tamanho+1)/2;
        }
        pivo = pivo-1;
        
        int valorNoPivo = 0;
        if (ordenadoPor=='U'){
            valorNoPivo = vetorOriginal.get(pivo).getU();
        }else if(ordenadoPor=='V'){
            valorNoPivo = vetorOriginal.get(pivo).getV();
        }
        
        //System.out.println("pivo="+pivo+",valorNoPivo="+valorNoPivo);
        if (tipo=='D'){
            for (int i=0;i<pivo;i++)
            {
                int valorLocal = 0;
                int valorU = vetorOriginal.get(i).getU();
                int valorV = vetorOriginal.get(i).getV();
                if (ordenadoPor=='U'){
                    valorLocal = valorU;
                }else if(ordenadoPor=='V'){
                    valorLocal = valorV;
                }
                if (valorLocal==valorNoPivo){
                    retorno.add(new Cor(valorU,valorV));
                }
            }
            for (int i=pivo;i<tamanho;i++){
                int valorU = vetorOriginal.get(i).getU();
                int valorV = vetorOriginal.get(i).getV();
                retorno.add(new Cor(valorU,valorV));
            }
        }else if(tipo=='E'){
            for (int i=0;i<=pivo;i++){
                int valorU = vetorOriginal.get(i).getU();
                int valorV = vetorOriginal.get(i).getV();
                retorno.add(new Cor(valorU,valorV));
            }
            for (int i=pivo+1;i<tamanho;i++)
            {
                int valorLocal = 0;
                int valorU = vetorOriginal.get(i).getU();
                int valorV = vetorOriginal.get(i).getV();
                if (ordenadoPor=='U'){
                    valorLocal = valorU;
                }else if(ordenadoPor=='V'){
                    valorLocal = valorV;
                }
                if (valorLocal==valorNoPivo){
                    retorno.add(new Cor(valorU,valorV));
                }else{
                    break;
                }
            }
        }
        
        return(retorno);
    }
    
    public static Cor getNovaCor(ArrayList<Cor> lista){
        int uSoma = 0;
        int vSoma = 0;
        for (Cor cor : lista){
            uSoma = uSoma + cor.getU();
            vSoma = vSoma + cor.getV();
        }
        Double uMedia = (uSoma+0.00)/(lista.size()+0.00);
        Double vMedia = (vSoma+0.00)/(lista.size()+0.00);
        
        Cor corMedia = new Cor(new Long(Math.round(uMedia)).intValue(),new Long(Math.round(vMedia)).intValue());
        
        return(corMedia);
    }
    
    
}
