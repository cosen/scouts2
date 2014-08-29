package br.com.k19.scouts.controladores;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.scouts.entidades.Jogador;
import br.com.k19.scouts.entidades.Pontuacao;
import br.com.k19.scouts.repositorios.JogadorRepositorio;

@ManagedBean
public class PontuacaoControlador {
	
	@EJB
	private JogadorRepositorio jogadorRepositorio;

	private Jogador jogador = new Jogador();

	private Pontuacao pontuacao = new Pontuacao();
	
	public String salva(){
		this.jogadorRepositorio.adicionaPontuacao(this.jogador, this.pontuacao);
		
		this.jogador = new Jogador();
		this.pontuacao = new Pontuacao();
		return "/index";
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Pontuacao getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Pontuacao pontuacao) {
		this.pontuacao = pontuacao;
	}
}
