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
    private int frequencia;
    public Cor media=null;

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
    
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
        this.frequencia=1;
    }
    
    @Override
    public String toString() {
        if (media!=null)
        return "[" + u + "," + v + "]("+frequencia+")("+media+")";
        else
        return "[" + u + "," + v + "]("+frequencia+")";
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.u;
        hash = 97 * hash + this.v;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cor other = (Cor) obj;
        if (this.u != other.u) {
            return false;
        }
        if (this.v != other.v) {
            return false;
        }
        return true;
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
        Cor corNoPivo = vetorOriginal.get(pivo);
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
                Cor corLocal = vetorOriginal.get(i);
                if (corNoPivo.equals(valorNoPivo)){
                    retorno.add(new Cor(corNoPivo.u,corNoPivo.v));
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
                Cor corLocal = vetorOriginal.get(i);
                if (corLocal.equals(corNoPivo)){
                    retorno.add(new Cor(corNoPivo.u,corNoPivo.v));
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
    
    public static Double diferencaCor(Cor cor1,Cor cor2){
        double x1 = cor1.getU();
        double y1 = cor1.getV();
        
        double x2 = cor2.getU();
        double y2 = cor2.getV();
        
        double diferenca = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
        return(diferenca);
    }
    
    
}
