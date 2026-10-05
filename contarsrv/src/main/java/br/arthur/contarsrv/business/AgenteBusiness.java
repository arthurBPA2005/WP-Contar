package br.arthur.contarsrv.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.arthur.contarsrv.domain.Agente;
import br.arthur.contarsrv.persistence.dao.AgenteDao;

public class AgenteBusiness {

	private final AgenteDao dao = new AgenteDao();

	/**
	 * status: "A" = ativos, "I" = inativos, vazio/null = todos
	 */
	public List<Agente> getList(Integer codAgente, String nomeAgente, String status) {
		StringBuilder condicao = new StringBuilder(" 1 = 1 ");
		Map<String, Object> parametros = new HashMap<>();

		if (codAgente != null && codAgente != 0) {
			condicao.append(" and obj.codAgente = :codAgente ");
			parametros.put("codAgente", codAgente);
		}

		if (nomeAgente != null && !nomeAgente.isBlank()) {
			condicao.append(" and upper(obj.nomeAgente) like :nomeAgente ");
			parametros.put("nomeAgente", "%" + nomeAgente.trim().toUpperCase() + "%");
		}

		if ("A".equals(status)) {
			condicao.append(" and obj.status = :status ");
			parametros.put("status", true);
		} else if ("I".equals(status)) {
			condicao.append(" and obj.status = :status ");
			parametros.put("status", false);
		}

		condicao.append(" order by obj.codAgente");

		return dao.getListByCond(condicao.toString(), parametros);
	}

}