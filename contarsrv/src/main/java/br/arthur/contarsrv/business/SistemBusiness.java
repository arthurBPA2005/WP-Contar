package br.arthur.contarsrv.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.arthur.contarsrv.domain.Sistema;
import br.arthur.contarsrv.persistence.dao.SistemaDao;

public class SistemBusiness {
	
	private final SistemaDao dao = new SistemaDao();

	public List<Sistema> getList(String codSistema, String nome) {

		StringBuilder condicao = new StringBuilder(" 1 = 1 ");
		Map<String, Object> parametros = new HashMap<>();

		if (codSistema != null && !codSistema.isBlank()) {
			condicao.append(" and obj.codSistema = :codSistema ");
			parametros.put("codSistema", codSistema.trim());
		}

		if (nome != null && !nome.isBlank()) {
			condicao.append(" and upper(obj.nome) like :nome ");
			parametros.put("nome", "%" + nome.trim().toUpperCase() + "%");
		}

		condicao.append(" order by obj.codSistema");

		return dao.getListByCond(condicao.toString(), parametros);
	}
	
	public Sistema getEntity(String codSistema) {

	    if (codSistema == null || codSistema.isBlank()) {
	        return null;
	    }

	    
	    return dao.getEntity(codSistema.trim());
	}
	
	public void novo(String codSistema, String nome) {

		if (codSistema == null || codSistema.isBlank()) {
			throw new IllegalArgumentException("Informe o código do sistema.");
		}

		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Informe o nome do sistema.");
		}

		codSistema = codSistema.trim();

		if (dao.getEntity(codSistema) != null) {
			throw new IllegalArgumentException("Já existe um sistema com o código " + codSistema + ".");
		}

		Sistema sistema = new Sistema();
		sistema.setCodSistema(codSistema);
		sistema.setNome(nome.trim());

		dao.create(sistema);
	}
	
	public void delete(String codSistema) {
		
		dao.delete(codSistema);
	}

}
