package br.com.k19.scouts.relatorios;

import br.com.k19.scouts.entidades.Jogador;
import br.com.k19.scouts.entidades.MetodoDePontuacao;

public class Classificacao implements Comparable<Classificacao> {

	private Jogador jogador;

	private int vitorias;

	private int empates;

	private int derrotas;

	private int gols;
	
	private int assistencias;
	
	private int golsContra;
	
	private double pontos;
	
	private double media;

	@Override
	public int compareTo(Classificacao c) {	
		if (this.pontos > c.pontos) {
			return 1;
		} else if (this.pontos < c.pontos) {
			return -1;
		} else {
			if (this.vitorias > c.vitorias) {
				return 1;
			} else if (this.vitorias < c.vitorias) {
				return -1;
			} else {
				if (this.gols > c.gols) {
					return 1;
				} else if (this.gols < c.gols) {
					return -1;
				} else {
					if (this.assistencias > c.assistencias) {
						return 1;
					} else if (this.assistencias < c.assistencias) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		}
	}
	
	public void calculaPontos(){
		this.pontos = this.vitorias * 3;
		this.pontos += this.empates * 1;
		this.pontos -= this.golsContra * 0.5;
		
		if(this.jogador.getMetodoDePontuacao() == MetodoDePontuacao.COMPLETO){
			this.pontos += this.gols * 0.5;
			this.pontos += this.assistencias * 0.5;
		} else if(this.jogador.getMetodoDePontuacao() == MetodoDePontuacao.SIMPLIFICADO) {
			this.pontos *= 1.05;
		}
		
		this.media = this.pontos / (this.vitorias + this.empates + this.derrotas);
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public int getAssistencias() {
		return assistencias;
	}

	public void setAssistencias(int assistencias) {
		this.assistencias = assistencias;
	}

	public int getGolsContra() {
		return golsContra;
	}

	public void setGolsContra(int golsContra) {
		this.golsContra = golsContra;
	}

	public double getPontos() {
		return pontos;
	}

	public void setPontos(double pontos) {
		this.pontos = pontos;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	public  int getJogos(){
		return this.vitorias + this.empates + this.derrotas;
	}
}
