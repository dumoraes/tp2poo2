/**
* Leitura e inserção no bd dos arquivos txt
*/

package util;

import entidade.Base;
import game.Luta;
import java.io.BufferedReader;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import main.Main;

public class FileUtil {
    
    public static void inserirdb() throws FileNotFoundException 
    {
        System.out.println("Inserir base");
        File dir = new File(new File("").getAbsolutePath(), "data");
        
        if(!dir.exists())
        {
        	throw new FileNotFoundException("Base de dados não existe.");
        }
        
        FileUtil util = new FileUtil();
        List<File> files = util.listFiles(dir);

        for (File file : files) 
        {
            //leitura de tds txt
            if (file.toString().endsWith(".txt") && file.toString().contains("")) 
            {
                try 
                {
                    List<String> data = util.readFile(file);

                    for (String line : data) 
                    {
                        Base o = new Base(line);
                        o.setLiga(Integer.parseInt(file.getName()
                                .replace("liga", "")
                                .replace(".txt", "")));
                        
                        Base.getInstance().persist(o);//salva no banco
                    }
                    
                } catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    
    public List<File> listFiles(File file) 
    {

        if (!file.exists()) 
        {

            System.err.println("Erro na lista de arquivos.");
            
            return listFile;
        }


        File[] files = file.listFiles();

        listFile.add(file);

        
        if (files != null) 
        {

            for (File dir : files) {
                listFiles(dir);
            }
        }
        return listFile;
    }
    
    
/**
* Lista de arquivos
*/
    
    private final List<File> listFile;

    public FileUtil() 
    {
        this.listFile = new ArrayList<File>();
    }


/**
* Ler os dados do arquivo
*/
    
    public List<String> readFile(File file) throws FileNotFoundException 
    {

        List<String> dados = new ArrayList<String>();

        if (!file.exists()) 
        {

            throw new FileNotFoundException("Arquivo " + file.toString() + " não encontrado.");
            
        } 
        else 
        {
            FileReader fr = null;
            BufferedReader br = null;
            try 
            {
                //construtores dos objetos
                fr = new FileReader(file);
                br = new BufferedReader(fr);

                //equanto houver linhas
                while (br.ready()) {

                    //proxima linha
                    String linha = br.readLine();

                    dados.add(linha);
                }

            } catch (IOException ex) {

                System.out.println("Falha ao ler o arquivo: \"" + file + "\"");

            } 
            finally  
            {

                //Arquivo criado
                if (fr != null && br != null) {
                    try {

                        fr.close();
                        br.close();

                    } catch (IOException ex) {

                        ex.printStackTrace();
                    }
                }
            }
            System.out.println("Leitura dos arquivos realizada.");
        }
        return dados;
    }

    //sleep do visor
    public static void esperar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
