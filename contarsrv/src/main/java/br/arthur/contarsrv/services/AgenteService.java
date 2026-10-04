package br.arthur.contarsrv.services;

import java.util.List;

import br.arthur.contarsrv.business.AgenteBusiness;
import br.arthur.contarsrv.domain.Sistema;

public class AgenteService {
	
	public List<Sistema> getList(Integer codAgente, String nomeAgente, boolean status) {

		AgenteBusiness pb = new AgenteBusiness();

		return pb.getList(codAgente, nomeAgente, status);

	}
}
