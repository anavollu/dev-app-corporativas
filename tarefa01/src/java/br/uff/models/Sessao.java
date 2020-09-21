package br.uff.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sessao {
    public int ID = 0;
    private final String path = "C:\\Users\\Felipe Vila\\Documents\\NetBeansProjects\\Calculator\\web\\controle\\";
    private final String nome_arquivo = "counts.txt";

    public Boolean criaArquivoControle() throws IOException {
        File arquivo = new File(path + nome_arquivo);
        boolean criou = false;
        
        if(arquivo.exists()){
            getHistoricoID();
            if(arquivo.delete()){
                criou = arquivo.createNewFile();
            }
        } else {
            criou = arquivo.createNewFile();
        }
        
        return criou;
        
    }
    
    public void getHistoricoID() throws IOException {
        File arquivo = new File(path + nome_arquivo);
        int historico = this.ID;
        
        try (Scanner reader = new Scanner(arquivo)) {
            while(reader.hasNextLine()){
                try {
                    historico = Integer.parseInt(reader.nextLine());
                } catch (NumberFormatException ex){
                    historico = this.ID;
                }
            }
            reader.close();
        }
        this.ID = historico;
    }
    
    public void atualizaHistorico() throws IOException {
        
        if(criaArquivoControle()){
            try (FileWriter writer = new FileWriter(path + nome_arquivo)) {
                writer.write(String.valueOf(ID + 1));
                writer.close();
                this.ID += 1;
            }
        }
    }
}
