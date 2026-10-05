package br.arthur.contarsrv.services;

import java.util.List;

import br.arthur.contarsrv.business.AgenteBusiness;
import br.arthur.contarsrv.domain.Agente;

public class AgenteService {
	
	public List<Agente> getList(Integer codAgente, String nomeAgente, String status) {

		AgenteBusiness pb = new AgenteBusiness();

		return pb.getList(codAgente, nomeAgente, status);

	}
}