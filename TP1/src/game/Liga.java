/**
* Essa classe Liga escreve na base do bd e retorna os principais metodos
*/ 

package game;

//Preciso criar a base dao e importar

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import javax.swing.JTextArea;
import entidade.Base;
import main.Main;
import util.FileUtil;

public class Liga {

	private final List<Base> base;

	public Liga() throws FileNotFoundException {

		//Escrever na base
		FileUtil.populateDatabase();

		//Recupera os jogadores de cada liga
		this.base = BaseDao.getInstance().findAll();

	}

	public Liga(JTextArea jTextArea1) throws FileNotFoundException {
		this();
	}

	public void popular(JTextArea jTextArea) {
		for (Base base1 : base) {
			
			//Cria os jogadores com os dados dos arquivos pelo BD
			Jogador jogador1 = new Jogador(base1, 0);
			Jogador jogador2 = new Jogador(base1, 1);

			// Luta
			Luta luta = new Luta(jogador1, jogador2, jTextArea);

			//Retorna o ganhador da luta
			Jogador win = luta.lutar();

			//Atualiza a linha do banco( não sei )
			luta.updateVencedor(win);
		}
	}
}
}
