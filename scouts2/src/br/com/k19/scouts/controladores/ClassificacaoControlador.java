package br.com.k19.scouts.controladores;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.scouts.relatorios.Classificacao;
import br.com.k19.scouts.servicos.ClassificacaoServico;

@ManagedBean
public class ClassificacaoControlador {

	@EJB
	private ClassificacaoServico classificacaoServico;

	private List<Classificacao> classificacao;

	private Calendar inicio = new GregorianCalendar(2014, 0, 1);

	private Calendar fim = Calendar.getInstance();

	public List<Classificacao> getClassificacao() {
		if (this.classificacao == null) {
			this.classificacao = this.classificacaoServico.geraClassificacao(
					this.inicio, this.fim);
		}

		return classificacao;
	}

	public Calendar getInicio() {
		return inicio;
	}

	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}

	public Calendar getFim() {
		return fim;
	}

	public void setFim(Calendar fim) {
		this.fim = fim;
	}
	
	public void atualiza(){
		this.classificacao = this.classificacaoServico.geraClassificacao(
				this.inicio, this.fim);
	}
}
