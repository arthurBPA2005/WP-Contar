package br.arthur.contarsrv.services;

import java.util.List;

import br.arthur.contarsrv.business.SistemBusiness;
import br.arthur.contarsrv.domain.Sistema;

public class SistemaService {

	public List<Sistema> getList(Integer codSistema, String nome) {

		SistemBusiness sistemBss = new SistemBusiness();
		return sistemBss.getList(codSistema, nome);
	}
}
