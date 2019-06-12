/**
* Essa classe realiza as comparções recebidas dos arquivos conforme bd
*/ 

package game;

import java.util.Random;
import javax.swing.JTextArea;
import main.Main;

public class Luta {

    private Jogador jogador1;
    private Jogador jogador2;
    
    private final Base base;
    
    private final JTextArea jTextArea;
    public static int ENERGIA = 10;
    
    
    //Declarando a luta 
    Luta(Jogador jogador1, Jogador jogador2, JTextArea jTextArea) {
 
    	//lutadores
    	this.base = jogador1.getBase();
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogador1.setAcao(jogador1.getAcao());
        this.jogador2.setAcao(jogador2.getAcao());
        
        this.jTextArea = jTextArea;
    }
    
    public Jogador lutar() {

        //Prepara a Luta
        jTextArea.append(jogador1.toString());
        jTextArea.append("Vs\t");
        jTextArea.append(jogador2.getNome());
        jTextArea.append("\n");
        jTextArea.append(">> LUTAR <<\n");

        //Começa a comparar a batalha
        printBatalha(jogador1, jogador2);//jogadores 1 e 2

       
        
        if (jogador1.poder() && !jogador2.poder()) {
            jogador2.perdeEnergiaPeloPorder();
            jTextArea.append(jogador1.getNome() + "Maquina recebeu poder e perdeu.\n");
            printPerdaEnergia(jogador1, jogador2);

        } else if (jogador2.poder() && !jogador1.poder()) {
            jogador1.perdeEnergiaPeloPorder();
            jTextArea.append("\t\t\t\t\t\t\t" + jogador2.getNome() + " poder " + jogador1.getNome() + " perdeu energia\n");
            printPerdaEnergia(jogador1, jogador2);

        } else if (jogador1.ataque(jogador2) && !jogador2.defesa(jogador1)) {
            jogador2.perdeEnergia();
            jTextArea.append(jogador1.getNome() + " atacou, e maquina perdeu energia\n");
            printPerdaEnergia(jogador1, jogador2);

        } else if (jogador2.ataque(jogador1) && !jogador1.defesa(jogador2)) {
            jogador1.perdeEnergia();
            jTextArea.append("\t\t\t\t\t\t\t" + jogador2.getNome() + " atacou " + jogador1.getNome() + " perdeu energia\n");
            printPerdaEnergia(jogador1, jogador2);

        } else if (jogador1.ataque(jogador2) && jogador2.defesa(jogador1)) {
            jTextArea.append("\t\t\t\t\t\t\t" + jogador2.getNome() + " defendeu\n");

        } else if (jogador2.ataque(jogador1) && jogador1.defesa(jogador2)) {
            jTextArea.append(jogador1.getNome() + " defendeu\n");

        } else {
            jTextArea.append("Golpe invalidado, defenderam\n");//maquina ou jogador defenderam
        }

        Jogador win = null;

        if (jogador1.getEnergia() < jogador2.getEnergia()) {
            win = jogador2;
        } 
        
        else if (jogador1.getEnergia() > jogador2.getEnergia()) {
            win = jogador1;
        } 
        
        else {
            win = null; //caso empate
        }

        return win;
}

    void printPerdaEnergia(Jogador j, Jogador m) {
        jTextArea.append(j.getNome() + " energia: " + j.getEnergia());
        jTextArea.append("\t\t\t\t\t");
        jTextArea.append(m.getNome() + " energia: " + m.getEnergia());
        jTextArea.append("\n");
    }

    public void printBatalha(Jogador j, Jogador m) {

        jTextArea.append("Ataque: " + j.getAcao().ataque + " Defesa: " + j.getAcao().defesa
                + " Chute: " + j.getAcao().chute + " Soco: " + j.getAcao().soco
                + " Poder: " + j.getAcao().poder);
        jTextArea.append("\t|\t");
        jTextArea.append("Ataque: " + m.getAcao().ataque + " Defesa: " + m.getAcao().defesa
                + " Chute: " + m.getAcao().chute + " Soco: " + m.getAcao().soco
                + " Poder: " + m.getAcao().poder);
        jTextArea.append("\n");

    }
}
    
    
