package br.arthur.contarsrv.services;

import br.arthur.contarsrv.domain.Tarefa;

public class TesteService {

	public String getVerdade(String nome) {

		System.out.println(nome);
		return nome + " e viado!";
	}

	public Tarefa getTerefa() {

		return new Tarefa();
	}

}
