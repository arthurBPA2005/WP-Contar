package br.arthur.contarsrv.business;

import java.util.List;

import br.arthur.contarsrv.domain.Sistema;
import br.arthur.contarsrv.persistence.dao.SistemaDao;

public class SistemBusiness {

	public List<Sistema> getList(Integer codSistema, String nome) {
		
		SistemaDao dao = new SistemaDao();
		//StringBuilder jpql = new StringBuilder();

		return dao.getList();
	}

}
