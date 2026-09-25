package br.arthur.contarsrv.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sistema")
public class Sistema {

	@Id
	@Column(name = "COD_SISTEMA")
	private String codSistema;

	@Column(name = "NOME")
	private String nome;

	public String getCodSistema() {
		return codSistema;
	}

	public void setCodSistema(String codSistema) {
		this.codSistema = codSistema;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Sistema sistema = (Sistema) o;
		return Objects.equals(codSistema, sistema.codSistema);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codSistema);
	}
}