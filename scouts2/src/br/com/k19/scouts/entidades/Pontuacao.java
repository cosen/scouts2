package br.com.k19.scouts.entidades;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity

@NamedQueries({ @NamedQuery(name = "Pontuacao.buscaPontuacao", query = "select x from Pontuacao x"), @NamedQuery(name = "Pontuacao.buscaPontuacaoPorData", query = "select x from Pontuacao x where x.data >= :inicio and x.data <= :fim") })
public class Pontuacao {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Jogador jogador;

	private int vitorias;

	private int empates;

	private int derrotas;

	private int gols;
	
	private int assistencias;
	
	private int golsContra;
	
	private Calendar data = Calendar.getInstance();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
}
