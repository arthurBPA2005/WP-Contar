package br.arthur.contarsrv.business;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.arthur.contarsrv.domain.Tarefa;
import br.arthur.contarsrv.persistence.dao.TarefaDao;

public class TarefaBusiness {

	private final TarefaDao dao = new TarefaDao();

	public List<Tarefa> getList(Integer codTarefa, String nome, Date dataInicio, Date dataFim, String status,
			Integer agente, String sistema) {

		StringBuilder condicao = new StringBuilder(" 1 = 1 ");
		Map<String, Object> parametros = new HashMap<>();

		if (codTarefa != null && codTarefa != 0) {
			condicao.append(" and obj.codTarefa = :codTarefa ");
			parametros.put("codTarefa", codTarefa);
		}

		if (nome != null && !nome.isBlank()) {
			condicao.append(" and upper(obj.nome) like :nome ");
			parametros.put("nome", "%" + nome.trim().toUpperCase() + "%");
		}

		if (status != null && !status.isBlank()) {
			condicao.append(" and obj.status = :status ");
			parametros.put("status", status.trim());
		}

		if (agente != null && agente != 0) {
			condicao.append(" and obj.codAgente = :codAgente ");
			parametros.put("codAgente", agente);
		}

		if (sistema != null && !sistema.isBlank()) {
			condicao.append(" and obj.codSistema = :codSistema ");
			parametros.put("codSistema", sistema.trim());
		}

		condicao.append(" order by obj.codTarefa");

		return dao.getListByCond(condicao.toString(), parametros);
	}

	public Tarefa getEntity(Integer codTarefa) {

		if (codTarefa == null || codTarefa == 0) {
			return null;
		}

		return dao.getEntity(codTarefa);
	}

	public Integer getProximoCodigo() {

		return dao.getNextCod("codTarefa");
	}

	public void novo(String nome, String descricao, Date dataInicio, Date dataFim, String status, Integer agente,
			String sistema) {

		valida(nome, descricao, status, agente, sistema);

		Tarefa tarefa = new Tarefa();
		tarefa.setNome(nome.trim());
		tarefa.setDescricao(descricao.trim());
		tarefa.setDataInicio(dataInicio);
		tarefa.setDataFim(dataFim);
		tarefa.setStatus(status.trim());
		tarefa.setAgente(agente);
		tarefa.setSistema(sistema.trim());

		dao.create(tarefa);
	}

	public void alterar(Integer codTarefa, String nome, String descricao, Date dataInicio, Date dataFim, String status,
			Integer agente, String sistema) {

		if (codTarefa == null || codTarefa == 0) {
			throw new IllegalArgumentException("Informe o código da tarefa.");
		}

		valida(nome, descricao, status, agente, sistema);

		Tarefa tarefa = new Tarefa();
		tarefa.setCodTarefa(codTarefa);
		tarefa.setNome(nome.trim());
		tarefa.setDescricao(descricao.trim());
		tarefa.setDataInicio(dataInicio);
		tarefa.setDataFim(dataFim);
		tarefa.setStatus(status.trim());
		tarefa.setAgente(agente);
		tarefa.setSistema(sistema.trim());

		dao.update(tarefa);
	}

	public void delete(Integer codTarefa) {

		dao.delete(codTarefa);
	}

	private void valida(String nome, String descricao, String status, Integer agente, String sistema) {

		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Informe o nome da tarefa.");
		}

		if (descricao == null || descricao.isBlank()) {
			throw new IllegalArgumentException("Informe a descrição da tarefa.");
		}

		if (status == null || status.isBlank()) {
			throw new IllegalArgumentException("Informe o status da tarefa.");
		}

		if (agente == null || agente == 0) {
			throw new IllegalArgumentException("Informe o código do agente.");
		}

		if (sistema == null || sistema.isBlank()) {
			throw new IllegalArgumentException("Informe o código do sistema.");
		}
	}

}
