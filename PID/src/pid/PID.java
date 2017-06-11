/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FREE
 */
public class PID {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println(args[0]);
        ArrayList< Cor > imagemBugada = new ArrayList<>();
        ArrayList< Cor > imagemOriginal = new ArrayList<>();
        //byte[] fileBytes = Files.readAllBytes(Paths.get(args[0]));
        Path filePath = Paths.get(args[0]);
        Scanner s = new Scanner(filePath);
        while (s.hasNext()){
            if (s.hasNextInt()){
                Cor cor = new Cor (s.nextInt(),s.nextInt());
                imagemBugada.add(cor);
                Cor cor2 = new Cor (cor.getU(),cor.getV());
                imagemOriginal.add(cor2);
            }else{
                s.next();
            }
        }
        System.out.println("bugada="+imagemBugada);
        
        ArrayList<Cor> mapeamento = Principal.subDividir(imagemBugada, 4);
        //Testes.main(args);
        ArrayList<Cor> novaImagem = new ArrayList<>();
        for (Cor cor : imagemOriginal){
            for (Cor corM : mapeamento){
                if (cor.equals(corM)){
                    novaImagem.add(corM);
                    break;
                }
            }
        }
        
        System.out.println("Nova 'original' = "+imagemOriginal);
        System.out.println("Nova bugada = "+imagemBugada);
        System.out.println("Nova imagem = "+novaImagem);
        
        File arquivo2 = new File ("gabarito.txt");//definindo o nome do locar do arquivo
        arquivo2.createNewFile ();//arquivo criado
       /*ESCREVER*/
        FileWriter fileW = new FileWriter (arquivo2);//arquivo para escrita
        BufferedWriter buffW = new BufferedWriter (fileW);
        int contador = 1;
        for (Cor cor : novaImagem){
            buffW.write(cor.media.getU()+"\t"+cor.media.getV()+"\t");
            if (contador%16==0){
                buffW.newLine();
            }
            contador++;
        }
        buffW.write("teste");
        buffW.flush();
            
    }
    
}
