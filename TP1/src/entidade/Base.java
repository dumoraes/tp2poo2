/**
 * Essa classe devera receber os dados vindo dos arquivos txt para o BD.
 */

package entidade;

import game.Acao;
import game.Jogador;
import java.io.Serializable;

public class Base implements Serializable {

    private int id;
    private int liga;
    private String vencedor;
    private String contadorLuta;
    
    private String nomeLutador1, nomeLutador2;
    private String categoriaLutador1, categoriaLutador2;
    private String paisLutador1, paisLutador2;
    private String sexoLutador1, sexoLutador2;
    private String defesaLutador1, defesaLutador2;
    private String ataqueLutador1, ataqueLutador2;
    private String socoLutador1, socoLutador2;
    private String chuteLutador1, chuteLutador2;
    private String poderLutador1, poderLutador2;
    private String modalidadeLutador1, modalidadeLutador2;
    
    private int pontosLutador1, pontosLutador2;
    private Jogador jogador1, jogador2;
    
    public Base() 
    {
        this.pontosLutador1 = 0;
        this.pontosLutador2 = 0;
    }

    public Base(String ) {

    //conferir como configurar o bd ??
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContadorLuta() {
        return contadorLuta;
    }

    public void setContadorLuta(String contadorLuta) {
        this.contadorLuta = contadorLuta;
    }

    public String getNomeLutador1() {
        return nomeLutador1;
    }

    public void setNomeLutador1(String nomeLutador1) {
        this.nomeLutador1 = nomeLutador1;
    }

    public String getCategoriaLutador1() {
        return categoriaLutador1;
    }

    public void setCategoriaLutador1(String categoriaLutador1) {
        this.categoriaLutador1 = categoriaLutador1;
    }

    public String getPaisLutador1() {
        return paisLutador1;
    }

    public void setPaisLutador1(String paisLutador1) {
        this.paisLutador1 = paisLutador1;
    }

    public String getSexoLutador1() {
        return sexoLutador1;
    }

    public void setSexoLutador1(String sexoLutador1) {
        this.sexoLutador1 = sexoLutador1;
    }

    public String getDefesaLutador1() {
        return defesaLutador1;
    }

    public void setDefesaLutador1(String defesaLutador1) {
        this.defesaLutador1 = defesaLutador1;
    }

    public String getAtaqueLutador1() {
        return ataqueLutador1;
    }

    public void setAtaqueLutador1(String ataqueLutador1) {
        this.ataqueLutador1 = ataqueLutador1;
    }

    public String getSocoLutador1() {
        return socoLutador1;
    }

    public void setSocoLutador1(String socoLutador1) {
        this.socoLutador1 = socoLutador1;
    }

    public String getChuteLutador1() {
        return chuteLutador1;
    }

    public void setChuteLutador1(String chuteLutador1) {
        this.chuteLutador1 = chuteLutador1;
    }

    public String getPoderLutador1() {
        return poderLutador1;
    }

    public void setPoderLutador1(String poderLutador1) {
        this.poderLutador1 = poderLutador1;
    }

    public String getModalidadeLutador1() {
        return modalidadeLutador1;
    }

    public void setModalidadeLutador1(String modalidadeLutador1) {
        this.modalidadeLutador1 = modalidadeLutador1;
    }

    public String getNomeLutador2() {
        return nomeLutador2;
    }

    public void setNomeLutador2(String nomeLutador2) {
        this.nomeLutador2 = nomeLutador2;
    }

    public String getCategoriaLutador2() {
        return categoriaLutador2;
    }

    public void setCategoriaLutador2(String categoriaLutador2) {
        this.categoriaLutador2 = categoriaLutador2;
    }

    public String getPaisLutador2() {
        return paisLutador2;
    }

    public void setPaisLutador2(String paisLutador2) {
        this.paisLutador2 = paisLutador2;
    }

    public String getSexoLutador2() {
        return sexoLutador2;
    }

    public void setSexoLutador2(String sexoLutador2) {
        this.sexoLutador2 = sexoLutador2;
    }

    public String getDefesaLutador2() {
        return defesaLutador2;
    }

    public void setDefesaLutador2(String defesaLutador2) {
        this.defesaLutador2 = defesaLutador2;
    }

    public String getAtaqueLutador2() {
        return ataqueLutador2;
    }

    public void setAtaqueLutador2(String ataqueLutador2) {
        this.ataqueLutador2 = ataqueLutador2;
    }

    public String getSocoLutador2() {
        return socoLutador2;
    }

    public void setSocoLutador2(String socoLutador2) {
        this.socoLutador2 = socoLutador2;
    }

    public String getChuteLutador2() {
        return chuteLutador2;
    }

    public void setChuteLutador2(String chuteLutador2) {
        this.chuteLutador2 = chuteLutador2;
    }

    public String getPoderLutador2() {
        return poderLutador2;
    }

    public void setPoderLutador2(String poderLutador2) {
        this.poderLutador2 = poderLutador2;
    }

    public String getModalidadeLutador2() {
        return modalidadeLutador2;
    }

    public void setModalidadeLutador2(String modalidadeLutador2) {
        this.modalidadeLutador2 = modalidadeLutador2;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public int getLiga() {
        return liga;
    }

    public void setLiga(int liga) {
        this.liga = liga;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public int getPontosLutador1() {
        return pontosLutador1;
    }

    public void setPontosLutador1(int pontosLutador1) {
        this.pontosLutador1 = pontosLutador1;
    }

    public int getPontosLutador2() {
        return pontosLutador2;
    }

    public void setPontosLutador2(int pontosLutador2) {
        this.pontosLutador2 = pontosLutador2;
    }
}
