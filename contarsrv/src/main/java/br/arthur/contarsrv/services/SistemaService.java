package br.arthur.contarsrv.services;

import java.util.List;

import br.arthur.contarsrv.business.SistemBusiness;
import br.arthur.contarsrv.domain.Sistema;

public class SistemaService {

	public List<Sistema> getList(String codSistema, String nome) {

		SistemBusiness pb = new SistemBusiness();

		return pb.getList(codSistema, nome);
	}

	public Sistema getEntity(String codSistema) {
		SistemBusiness pb = new SistemBusiness();

		return pb.getEntity(codSistema);
	}

	public void novo(String codSistema, String nome) {
		SistemBusiness pb = new SistemBusiness();

		pb.novo(codSistema, nome);
	}
	
	public void alterar(String codSistema, String nome) {
		SistemBusiness pb = new SistemBusiness();

		pb.alterar(codSistema, nome);
	}

	public void delete(String codSistema) {
		SistemBusiness pb = new SistemBusiness();

		pb.delete(codSistema);
	}

}
