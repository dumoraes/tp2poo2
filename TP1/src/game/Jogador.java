package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entidade.Base;

public class Jogador {
	
	//atributos do jogador
	private String nome;
    private int pontos;//pontos para habilidades
    private int vida;//vida do jogador
    private List<Modalidade> modalidades;//lista de modalidades
    private Modalidade modalidade;
    private Acao acao;

    public Jogador(Base base, int i) {
        this.base = base;

        this.modalidades = new ArrayList<Modalidade>();
        if (i == 0) {

            this.nome = base.getNomeLutador1();
            this.modalidade = getModalidade(Integer.parseInt(base.getModalidadeLutador1()));

            this.acao = new Acao(// ataque, soco, chute, poder, defesa
            		
                    Integer.parseInt(base.getAtaqueLutador1()),
                    Integer.parseInt(base.getSocoLutador1()),
                    Integer.parseInt(base.getChuteLutador1()),
                    Integer.parseInt(base.getPoderLutador1()),
                    Integer.parseInt(base.getDefesaLutador1()));

        } 
        
        else {

            this.nome = base.getNomeLutador2();
            
            this.modalidade = getModalidade(Integer.parseInt(base.getModalidadeLutador2()));
            
            this.acao = new Acao(// ataque, soco, chute, poder, defesa
            		
                    Integer.parseInt(base.getAtaqueLutador1()),
                    Integer.parseInt(base.getSocoLutador1()),
                    Integer.parseInt(base.getChuteLutador1()),
                    Integer.parseInt(base.getPoderLutador1()),
                    Integer.parseInt(base.getDefesaLutador1()));

        }
        
        this.modalidades.add(modalidade);
        
        this.energia = 10;
    }    
    

    public Jogador(String nome) {
    	
        this.vida =100 ;//recebe 10 pontos de vida
        this.nome = nome;
        this.modalidade = new Boxe();//recebe a modalidade Boxe inicialmente
        this.modalidades = new ArrayList<Modalidade>();//Array de Modalidades
        this.modalidades.add(modalidade);
    }
    
    private Modalidade getModalidade(int i) {

        if (i == 0) {
            return new Boxe();
        }

        if (i == 1) {
            this.setPontos(1000);
            return new JiuJitsu();
        }

        if (i == 2) {
            this.setPontos(2000);
            return new MuayThai();
        }

        if (i == 3) {
            this.setPontos(3000);
            return new Wrestling();
        }

        if (i == 4) {
            this.setPontos(4000);
            return new Karate();
        }

        return new Boxe();
    }
    
    //Metodo perder vida do jogador
    void perder_Vida() {
        this.vida--;
    }
    
    
    //Poder tira vida
    void Poder_tira_Vida() {
        this.vida = this.vida - (Luta.ENERGIA / 2);
       
        //Se vida menor que zero vida recebe 0, nunca negativo
        if (vida < 0) {
            vida = 0;
        }
    }

        
    //Booleano Ataque retorna true e false para as condições abaixo
    //Entre o Soco e Chute vence quem chutou
    boolean ataque(Jogador lutador) {
    	
        Acao acao_jog = this.acao;
        Acao acao_maq = lutador.getAcao();
        
        int hab_jog = this.modalidades.size();
        int hab_maq = lutador.getModalidades().size();

        
        if (acao_jog.ataque == 1 ) {
            return true;
        
        //Se jogador ataca e maq ataca ou maq defende    
        } else if (acao_jog.ataque == 1 && acao_maq.ataque == 1 || acao_jog.ataque == 1 && acao_maq.defesa == 1) {
            return false;
        
        //Se jogador da socos e chutes
        } else if (acao_jog.soco == 1 && acao_jog.soco == 1 || acao_jog.chute == 1 && acao_jog.chute == 1) {
           
        	//Se habilidade do jogador maior que maquina
        	if (hab_jog > hab_maq) {
                return true;
            }
            	return false;
            	
        //Se o jogador chuta ele ganha    	
        } else if (acao_jog.chute == 1 || acao_jog.soco == 1) {
            
            return true;
        
        //Chute perde para o soco
        } else if (acao_jog.soco == 1 && acao_jog.chute == 1) {
            return false;
        }
        //Soco e defesa: nenhum jogador perde ponto
        return false;
    }
    
    
    
    //Booleano de Defesa retorna true e false para as condições abaixo
    //2. Chute e defesa: nenhum jogador perde ponto
    //3. Defesa e defesa: nenhum jogador perde ponto
    boolean defesa(Jogador lutador) {
        
    	Acao acao_jog = this.acao;
        Acao acao_maq = lutador.getAcao();
        
        //se ele defendeu e a maquina nao usou poder
        if (acao_jog.defesa == 1 && acao_maq.poder == 0) {
            return true;
        }
        //se não entrar no if é pq lancou o poder
        return false;
    }

    
    //Booleano do Poder retorna conforme condições abaixo
    //6. Poder contra qualquer outro golpe: ganha o jogador do poder
    boolean poder() {

        Acao acao_jog = this.acao;
       
        if (acao_jog.poder == 1) {
            
        	
        	//Se tiver mais de uma modalidade faz a escolha aleatoria do poder
            if (this.modalidades.size() > 1) {

                Random r = new Random();
                int x = r.nextInt(this.modalidades.size());
                this.modalidade = this.modalidades.get(x);
            }
            return true;
        }
        return false;
    }
    
    
    //Checa a qtd de pontos para atribuir a modalidade
    public void setPontos(int pontos) {
        
    	this.pontos = pontos;   	
        int cont_Modalidades = this.modalidades.size();
       
        //Verifica o cont modalidades e os pontos necessarios para cada poder
        if (cont_Modalidades == 0 && this.pontos >= 1000) {
            this.modalidades.add(new JiuJitsu());
        } 
        else if (cont_Modalidades == 1 && this.pontos >= 2000) {
            this.modalidades.add(new MuayThai());
        } 
        else if (cont_Modalidades == 2 && this.pontos >= 3000) {
            this.modalidades.add(new Wrestling());
        } 
        else if (cont_Modalidades == 3 && this.pontos >= 4000) {
            this.modalidades.add(new Karate());
        } else {
            //Se entrar nesse else todos poderes estão liberados
        }
    }

    public List<Modalidade> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<Modalidade> modalidades) {
        this.modalidades = modalidades;
    }

    public int getEnergia() {
        return vida;
    }

    public int getPontos() {
        return pontos;
    }
    
    boolean isEnergia() {
        return this.vida > 0;
    }

    public String getNome() {
        return nome;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Acao getAcao() {
        return acao;
    }

    @Override
    public String toString() {
        return nome;
    }

}
