package br.com.cod3r.cm.visao;

import java.awt.GridLayout;

import javax.swing.JPanel;

import br.com.cod3r.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {
	/*
	 *  É um componente que agrupa outros componentes dentro dele,
	 * então, dentro dele tem uma serie de botões, e cada botão
	 * representando um canto do jogo.
	 */
	
	public PainelTabuleiro(Tabuleiro tabuleiro) {
		
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		// Vai definir como os componentes visuais ficaram na tela
		/*
		 *  Para o "GridLayout()" tem que passar a quantidade de 
		 * linhas e colunas que serão usados e fará uma grade
		 */
		
		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
		// Aqui ele cria os botões do jogo, tem como criar por forEach também
		
		tabuleiro.registrarObservador(e -> {
			// TODO mostrar resultado pro usuário
			
			tabuleiro.reiniciar();
		});
	}
}
