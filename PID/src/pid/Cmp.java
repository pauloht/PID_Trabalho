/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pid;

import java.util.Comparator;

/**
 *
 * @author FREE
 */
public class Cmp implements Comparator{
    private CmpEnum tipo = null;
            
    public Cmp(CmpEnum tipo)
    {
        this.tipo = tipo;
    }
    
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Cor && o2 instanceof Cor){
            Cor cor1 = (Cor)o1;
            Cor cor2 = (Cor)o2;
            int valor1 = 0;
            int valor2 = 0;
            int valor3 = 0;
            int valor4 = 0;
            if (tipo==CmpEnum.UMAIOR){
                valor1 = cor1.getU();
                valor2 = cor2.getU();
                valor3 = cor1.getV();
                valor4 = cor2.getV();
            }
            else if (tipo==CmpEnum.VMAIOR)
            {
                valor1 = cor1.getV();
                valor2 = cor2.getV();
                valor3 = cor1.getU();
                valor4 = cor2.getU();
            }
            if (valor1-valor2!=0){
                return(valor1-valor2);
            }else{
                return(valor3-valor4);
            }
        }
        else{
            System.err.println("Erro tentando comparar objetos que nao sao da classe cor");
        }
        return(0);
    }
    
}
