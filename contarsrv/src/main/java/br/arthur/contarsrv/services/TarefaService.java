package br.arthur.contarsrv.services;

import java.util.Date;
import java.util.List;

import br.arthur.contarsrv.business.TarefaBusiness;
import br.arthur.contarsrv.domain.Tarefa;

public class TarefaService {

	public List<Tarefa> getList(Integer codTarefa, String nome, Date dataInicio, Date dataFim, String status, Integer agente, String sistema) {

		TarefaBusiness pb = new TarefaBusiness();

		return pb.getList(codTarefa, nome, dataInicio, dataFim, status, agente, sistema);
	}

	public Tarefa getEntity(Integer codTarefa) {
		TarefaBusiness pb = new TarefaBusiness();

		return pb.getEntity(codTarefa);
	}

	public Integer getProximoCodigo() {
		TarefaBusiness pb = new TarefaBusiness();

		return pb.getProximoCodigo();
	}

	public void novo(String nome, String descricao, Date dataInicio, Date dataFim, String status, Integer agente, String sistema) {
		TarefaBusiness pb = new TarefaBusiness();

		pb.novo(nome, descricao, dataInicio, dataFim, status, agente, sistema);
	}

	public void alterar(Integer codTarefa, String nome, String descricao, Date dataInicio, Date dataFim, String status, Integer agente, String sistema) {
		TarefaBusiness pb = new TarefaBusiness();

		pb.alterar(codTarefa, nome, descricao, dataInicio, dataFim, status, agente, sistema);
	}

	public void delete(Integer codTarefa) {
		TarefaBusiness pb = new TarefaBusiness();

		pb.delete(codTarefa);
	}
}
