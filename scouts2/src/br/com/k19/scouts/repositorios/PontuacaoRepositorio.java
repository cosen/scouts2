package br.com.k19.scouts.repositorios;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.k19.scouts.entidades.Pontuacao;

@Stateless
public class PontuacaoRepositorio {

	@PersistenceContext
	private EntityManager manager;

	public void salva(Pontuacao pontuacao) {
		this.manager.persist(pontuacao);
	}

	public Pontuacao buscaPorId(Long id) {
		return this.manager.find(Pontuacao.class, id);
	}

	public List<Pontuacao> buscaPontuacoes() {
		TypedQuery<Pontuacao> query = this.manager.createNamedQuery(
				"Pontuacao.buscaPontuacao", Pontuacao.class);
		return query.getResultList();
	}

	public List<Pontuacao> buscaPontuacoes(Calendar inicio, Calendar fim) {
		TypedQuery<Pontuacao> query = this.manager.createNamedQuery(
				"Pontuacao.buscaPontuacaoPorData", Pontuacao.class);

		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);
		
		return query.getResultList();
	}
}
