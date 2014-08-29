package br.com.k19.scouts.servicos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.k19.scouts.entidades.Jogador;
import br.com.k19.scouts.entidades.Pontuacao;
import br.com.k19.scouts.relatorios.Classificacao;
import br.com.k19.scouts.repositorios.PontuacaoRepositorio;

@Stateless
public class ClassificacaoServico {

	@EJB
	private PontuacaoRepositorio pontuacaoRepositorio;
	
	public List<Classificacao> geraClassificacao(Calendar inicio, Calendar fim) {
		Map<Jogador, Classificacao> mapa = new HashMap<Jogador, Classificacao>();
		List<Pontuacao> pontuacoes = this.pontuacaoRepositorio.buscaPontuacoes(inicio, fim);
		
		for (Pontuacao p : pontuacoes) {
			if(!mapa.containsKey(p.getJogador())){
				mapa.put(p.getJogador(), new Classificacao());
				mapa.get(p.getJogador()).setJogador(p.getJogador());
			}
			
			Classificacao c = mapa.get(p.getJogador());
			
			c.setVitorias(c.getVitorias() + p.getVitorias());
			c.setEmpates(c.getEmpates() + p.getEmpates());
			c.setDerrotas(c.getDerrotas() + p.getDerrotas());
			c.setGols(c.getGols() + p.getGols());
			c.setAssistencias(c.getAssistencias() + p.getAssistencias());
			c.setGolsContra(c.getGolsContra() + p.getGolsContra());
		}

		List<Classificacao> classificacaoGeral = new ArrayList<Classificacao>(mapa.values());
		for (Classificacao c : classificacaoGeral) {
			c.calculaPontos();
		}
		
		Collections.sort(classificacaoGeral);
		Collections.reverse(classificacaoGeral);
		return classificacaoGeral;
	}
}
