package br.com.k19.scouts.repositorios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.k19.scouts.entidades.Jogador;
import br.com.k19.scouts.entidades.Pontuacao;

@Stateless
public class JogadorRepositorio {

	@PersistenceContext
	private EntityManager manager;

	public void salva(Jogador jogador) {
		this.manager.persist(jogador);
	}

	public Jogador buscaPorId(Long id) {
		return this.manager.find(Jogador.class, id);
	}

	public List<Jogador> buscaJogadores() {
		TypedQuery<Jogador> query = this.manager.createNamedQuery(
				"Jogador.buscaJogador", Jogador.class);
		return query.getResultList();
	}

	public void adicionaPontuacao(Jogador jogador, Pontuacao pontuacao) {
		this.manager.persist(pontuacao);

		Jogador j = this.manager.find(Jogador.class, jogador.getId());
		j.getPontuacoes().add(pontuacao);
		
		pontuacao.setJogador(j);
	}
}
