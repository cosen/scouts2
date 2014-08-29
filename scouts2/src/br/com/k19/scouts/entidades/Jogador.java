package br.com.k19.scouts.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Jogador.buscaJogador", query = "select x from Jogador x order by x.nome") })
public class Jogador {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private MetodoDePontuacao metodoDePontuacao = MetodoDePontuacao.COMPLETO;
	
	
	@OneToMany(mappedBy="jogador")
	private List<Pontuacao> pontuacoes;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public MetodoDePontuacao getMetodoDePontuacao() {
		return metodoDePontuacao;
	}


	public void setMetodoDePontuacao(MetodoDePontuacao metodoDePontuacao) {
		this.metodoDePontuacao = metodoDePontuacao;
	}


	public List<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}


	public void setPontuacoes(List<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}
}
