/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author FREE
 */
public class Testes {
    public static void main(String args[]){
        test4();
    }
    
    private static void test1(){
        ArrayList< Cor > lista = new ArrayList<>();
        Random gem = new Random();

        for (int i=0;i<20;i++){
            Cor newCor = new Cor(gem.nextInt(1000),gem.nextInt(1000));
            lista.add(newCor);
        }
        
        Cor dif = Cor.difDosCanais(lista);
        

        Cmp comparator1 = new Cmp(CmpEnum.UMAIOR);
        Cmp comparator2 = new Cmp(CmpEnum.VMAIOR);

        Collections.sort(lista, comparator1);

        System.out.println(lista);

        Collections.sort(lista, comparator2);

        System.out.println(lista);
        
        System.out.println("diferenca = " + dif);
    }
    
    private static void test2(){
        ArrayList< Cor > lista = new ArrayList<>();
        Random gem = new Random();

        for (int i=0;i<10;i++){
            Cor newCor = new Cor(gem.nextInt(4),gem.nextInt(4));
            lista.add(newCor);
        }
        
        Cmp comparator1 = new Cmp(CmpEnum.UMAIOR);
        Cmp comparator2 = new Cmp(CmpEnum.VMAIOR);

        Collections.sort(lista, comparator1);
        
        ArrayList< Cor > subEsquerdaU = Cor.gerarSubVetor(lista, 'E', 'U');
        ArrayList< Cor > subDireitaU = Cor.gerarSubVetor(lista, 'D', 'U');
        System.out.println("OriginalSort1 : " + lista);
        
        Collections.sort(lista, comparator2);
        ArrayList< Cor > subEsquerdaV = Cor.gerarSubVetor(lista, 'E', 'V');
        ArrayList< Cor > subDireitaV = Cor.gerarSubVetor(lista, 'D', 'V');
        System.out.println("OriginalSort2 : " + lista);
        
        
        System.out.println("SubE_U : " + subEsquerdaU + "\n" +
                           "SubD_U : " + subDireitaU + "\n" +
                           "SubE_V : " + subEsquerdaV + "\n" +
                           "SubD_V : " + subDireitaV + "\n");
        
        
    }
    
    private static void test3(){
        //exercicio da apostila
        ArrayList< Cor > lista = new ArrayList<>();

        lista.add(new Cor(1,2));
        lista.add(new Cor(1,2));
        lista.add(new Cor(2,6));
        lista.add(new Cor(2,6));
        lista.add(new Cor(3,8));
        lista.add(new Cor(4,5));
        lista.add(new Cor(4,5));
        lista.add(new Cor(4,5));
        lista.add(new Cor(5,1));
        lista.add(new Cor(5,1));
        lista.add(new Cor(6,3));
        lista.add(new Cor(7,7));
        lista.add(new Cor(8,4));
        lista.add(new Cor(8,4));
        lista.add(new Cor(9,2));
        
        Cmp comparator1 = new Cmp(CmpEnum.UMAIOR);
        Cmp comparator2 = new Cmp(CmpEnum.VMAIOR);

        Collections.sort(lista, comparator1);
        
        Cor dif = Cor.difDosCanais(lista);
        System.out.println("dif="+dif);
        
        ArrayList< Cor > subEsquerdaU = Cor.gerarSubVetor(lista, 'E', 'U');
        ArrayList< Cor > subDireitaU = Cor.gerarSubVetor(lista, 'D', 'U');
        System.out.println("OriginalSort1 : " + lista);
        
        Collections.sort(lista, comparator2);
        ArrayList< Cor > subEsquerdaV = Cor.gerarSubVetor(lista, 'E', 'V');
        ArrayList< Cor > subDireitaV = Cor.gerarSubVetor(lista, 'D', 'V');
        System.out.println("OriginalSort2 : " + lista);
        
        
        System.out.println("SubE_U : " + subEsquerdaU + "\n" +
                           "SubD_U : " + subDireitaU + "\n" +
                           "SubE_V : " + subEsquerdaV + "\n" +
                           "SubD_V : " + subDireitaV + "\n");
        
        
    }
    
    private static void test4(){
        //exercicio da apostila
        ArrayList< Cor > lista = new ArrayList<>();

        lista.add(new Cor(1,2));
        lista.add(new Cor(1,2));
        lista.add(new Cor(2,6));
        lista.add(new Cor(2,6));
        lista.add(new Cor(3,8));
        lista.add(new Cor(4,5));
        lista.add(new Cor(4,5));
        lista.add(new Cor(4,5));
        lista.add(new Cor(5,1));
        lista.add(new Cor(5,1));
        lista.add(new Cor(6,3));
        lista.add(new Cor(7,7));
        lista.add(new Cor(8,4));
        lista.add(new Cor(8,4));
        lista.add(new Cor(9,2));
        
        Principal.subDividir(lista, 2);
        
        
    }
    
    private static void test5(){
        //exercicio da apostila
        ArrayList< Cor > lista = new ArrayList<>();
        Random gem = new Random();

        for (int i=0;i<10;i++){
            Cor newCor = new Cor(gem.nextInt(8),gem.nextInt(8));
            lista.add(newCor);
        }
        
        Principal.subDividir(lista, 2);
        
        
        
        
    }
}
