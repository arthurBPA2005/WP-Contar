package br.arthur.contarsrv.business;

import java.util.Calendar;
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

		// tarefas que comecam a partir do dia informado (00:00:00)
		if (dataInicio != null) {
			condicao.append(" and obj.dataInicio >= :dataInicio ");
			parametros.put("dataInicio", inicioDoDia(dataInicio));
		}

		// tarefas finalizadas ate o dia informado (23:59:59)
		if (dataFim != null) {
			condicao.append(" and obj.dataFim <= :dataFim ");
			parametros.put("dataFim", fimDoDia(dataFim));
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

	private Date inicioDoDia(Date data) {

		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}

	private Date fimDoDia(Date data) {

		Calendar c = Calendar.getInstance();
		c.setTime(data);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);

		return c.getTime();
	}

	public Tarefa getEntity(Integer codTarefa) {

		if (codTarefa == null || codTarefa == 0) {
			return null;
		}

		return dao.getEntity(codTarefa);
	}

	/**
	 * Previsao do proximo codigo (maior codigo + 1), so para exibir na tela.
	 * Quem gera o codigo de verdade e o banco (IDENTITY) no momento do insert.
	 */
	public Integer getProximoCodigo() {

		return dao.getNextCod("codTarefa");
	}

	public void novo(String nome, String descricao, Date dataInicio, Date dataFim, String status, Integer agente,
			String sistema) {

		// o codigo da tarefa e gerado pelo banco (IDENTITY)
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

	public void alterar(Integer codTarefa, String nome, String descricao, Date dataInicio, Date dataFim,
			String status, Integer agente, String sistema) {

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
