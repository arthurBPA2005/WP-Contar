package br.arthur.contarsrv.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.arthur.contarsrv.domain.Sistema;
import br.arthur.contarsrv.persistence.dao.SistemaDao;

public class AgenteBusiness {

	public List<Sistema> getList(Integer codAgente, String nomeAgente, boolean status) {

		SistemaDao dao = new SistemaDao();
		StringBuilder condicao = new StringBuilder("1 = 1");
		
		Map<String, Object> parametros = new HashMap<>();

//		if (codAgente != null && !codAgente.isBlank()) {
//			condicao.append(" and obj.codSistema = :codSistema");
//			parametros.put("codSistema", codSistema.trim());
//		}
//
//		if (nome != null && !nome.isBlank()) {
//			condicao.append(" and upper(obj.nome) like :nome");
//			parametros.put("nome", "%" + nome.trim().toUpperCase() + "%");
//		}

		condicao.append(" order by obj.nome");

		return dao.getListByCond(condicao.toString(), parametros);
	}

}
