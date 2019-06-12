/*
 * Classe do placar utilizada anteriormente no tp1
 */

package game;

//Classe do Placar dos jogadores
public class Placar {
    
    private int vitorias;
    private int empate;
    private int derrotas;

    private Jogador jogador;
    
    public Placar() {
    }
    
    public Placar(Jogador jogador) {
        this.vitorias = 0;
        this.derrotas = 0;
        this.jogador = jogador;
    }

    public int getVitorias() {
        return vitorias;
    }
    
    //Contador de vitorias
    public void vitoria() {
        this.vitorias ++;
    }
    
    //Contator de derrotas
    public int derrota() {
        return derrotas++;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public int getEmpate() {
        return empate;
    }
    //Contador de empates
    public void empate() {
        this.empate++;
    }
    
    //Transforma a string e retorna os resultados
    @Override
    public String toString() {
        return "\nJogador:\t" + jogador 
             + "\nVitorias:\t" + vitorias 
             + "\nDerrotas:\t" + derrotas;
    }
    
}
