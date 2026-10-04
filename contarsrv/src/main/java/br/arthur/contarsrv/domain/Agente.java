package br.arthur.contarsrv.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agente")
public class Agente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_AGENTE")
	private Integer codAgente;

	@Column(name = "NOME", length = 45, nullable = false)
	private String nomeAgente;

	@Column(name = "STATUS", nullable = false, columnDefinition = "TINYINT")
	private boolean status;

	public Agente() {
	}

	public Agente(String nomeAgente, boolean status) {

		this.nomeAgente = nomeAgente;
		this.status = status;
	}

	public Integer getCodAgente() {
		return codAgente;
	}

	public void setCodAgente(Integer codAgente) {
		this.codAgente = codAgente;
	}

	public String getNomeAgente() {
		return nomeAgente;
	}

	public void setNomeAgente(String nomeAgente) {
		this.nomeAgente = nomeAgente;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Agente [codAgente=" + codAgente + ", nomeAgente=" + nomeAgente + ", status=" + status + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Agente agente = (Agente) o;
		return Objects.equals(codAgente, agente.codAgente);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codAgente);
	}

}
