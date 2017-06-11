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
 * @author elixandrebaldi
 */
public class tabelaFrequencia {
    private ArrayList<Cor> coresFrequencia = new ArrayList<>();
    private Cor media;
    
    public tabelaFrequencia(ArrayList<Cor> ListaCor){
        for (Cor cor : ListaCor){
            if (coresFrequencia.contains(cor)){
                for (int i=0;i<coresFrequencia.size();i++){
                    if (coresFrequencia.get(i).equals(cor)){
                        coresFrequencia.get(i).setFrequencia(coresFrequencia.get(i).getFrequencia()+1);
                        break;
                    }
                }
            }else{
                coresFrequencia.add(cor);
            }
        }
        media = Cor.getNovaCor(ListaCor);
    }

    @Override
    public String toString() {
        return (coresFrequencia.toString()+"Media="+media+"\nFrequenciaTotal:"+somaFrequencia());
    }
    
    private int somaFrequencia(){
        int retorno = 0;
        for (Cor cor : coresFrequencia){
            retorno = retorno + cor.getFrequencia();
        }
        return(retorno);
    }

    public Cor getMedia() {
        return media;
    }
    
    public static ArrayList<Cor> getCoresMedias(List<tabelaFrequencia> listaTabelas){
        ArrayList<Cor> cores = new ArrayList<>();
        
        
        for  (tabelaFrequencia tabela : listaTabelas){
            for (Cor cor : tabela.coresFrequencia){
                if (!cores.contains(cor)){
                    ArrayList<Cor> mediasDaCor = new ArrayList<>();
                    for  (tabelaFrequencia tabela2 : listaTabelas){
                        for (Cor cor2 : tabela2.coresFrequencia){
                            if (cor2.equals(cor)){
                                mediasDaCor.add(tabela2.media);
                            }
                        }
                    }
                    Cor menorErroCor = mediasDaCor.get(0);
                    double menorErro = Cor.diferencaCor(cor, mediasDaCor.get(0));
                    for (int i=1;i<mediasDaCor.size();i++){
                        Cor outraCor = mediasDaCor.get(i);
                        double outroErro = Cor.diferencaCor(cor,mediasDaCor.get(i));
                        if (outroErro<menorErro){
                            menorErroCor = outraCor;
                            menorErro = outroErro;
                        }
                    }
                    cor.media = menorErroCor;
                    cores.add(cor);
                }
            }
        }
        
        return(cores);
    }
    
    
}
