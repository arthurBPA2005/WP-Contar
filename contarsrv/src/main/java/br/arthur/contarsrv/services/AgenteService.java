package br.arthur.contarsrv.services;

import java.util.List;

import br.arthur.contarsrv.business.AgenteBusiness;
import br.arthur.contarsrv.domain.Agente;

public class AgenteService {

	public List<Agente> getList(Integer codAgente, String nomeAgente, String status) {

		AgenteBusiness pb = new AgenteBusiness();

		return pb.getList(codAgente, nomeAgente, status);
	}

	public Agente getEntity(Integer codAgente) {
		AgenteBusiness pb = new AgenteBusiness();

		return pb.getEntity(codAgente);
	}

	public Integer getProximoCodigo() {
		AgenteBusiness pb = new AgenteBusiness();

		return pb.getProximoCodigo();
	}

	public void novo(String nome, boolean status) {
		AgenteBusiness pb = new AgenteBusiness();

		pb.novo(nome, status);
	}

	public void alterar(Integer codAgente, String nome, boolean status) {
		AgenteBusiness pb = new AgenteBusiness();

		pb.alterar(codAgente, nome, status);
	}

	public void delete(Integer codAgente) {
		AgenteBusiness pb = new AgenteBusiness();

		pb.delete(codAgente);
	}
}