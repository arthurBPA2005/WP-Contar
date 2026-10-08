package br.arthur.contarsrv.business;

import java.util.Date;
import java.util.List;

import br.arthur.contarsrv.domain.Tarefa;
import br.arthur.contarsrv.persistence.dao.SistemaDao;

public class TarefaBusiness {

	private final SistemaDao dao = new SistemaDao();

	public List<Tarefa> getList(Integer codTarefa, String nome, String descricao, Date dataInicio, String status,
			Integer agente, String sistema) {

		return null;
	}

	public Tarefa getEntity(Integer codTarefa) {

		return null;
	}

	public Integer getProximoCodigo() {

		return dao.getNextCod("codAgente");
	}

	public void novo(String nome, String status) {

	}

	public void alterar(Integer codTarefa, String nome, String descricao, Date dataInicio, String status,
			Integer agente, String sistema) {

	}

	public void delete(Integer codTarefa) {

	}

}
