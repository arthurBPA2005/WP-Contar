package br.arthur.contarsrv.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tarefa")
public class Tarefa {

	private static final String FORMATO_DATA = "dd/MM/yyyy";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_TAREFA")
	private Integer codTarefa;

	@Column(name = "Nome", length = 45, nullable = false)
	private String nome;

	@Column(name = "TAREFA", nullable = false, columnDefinition = "text")
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_INICIO")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_FIM")
	private Date dataFim;

	@Column(name = "STATUS", nullable = false, columnDefinition = "enum('Pendente','Em andamento','Concluído')")
	private String status;

	@Column(name = "Sistema_COD_SISTEMA", nullable = false)
	private String codSistema;

	@Column(name = "Agente_COD_AGENTE", nullable = false)
	private Integer codAgente;

	public Tarefa() {
	}

	public Tarefa(String nome, String descricao, Date dataInicio, String status, Integer agente, String sistema) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.status = status;
		this.codAgente = agente;
		this.codSistema = sistema;
	}

	public Integer getCodTarefa() {
		return codTarefa;
	}

	public void setCodTarefa(Integer codTarefa) {
		this.codTarefa = codTarefa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataInicioFormatada() {
		return dataInicio == null ? "-" : new SimpleDateFormat(FORMATO_DATA).format(dataInicio);
	}

	public String getDataInicioISO() {
		return dataInicio == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(dataInicio);
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSistema() {
		return codSistema;
	}

	public void setSistema(String sistema) {
		this.codSistema = sistema;
	}

	public Integer getAgente() {
		return codAgente;
	}

	public void setAgente(Integer agente) {
		this.codAgente = agente;
	}

	@Override
	public String toString() {
		return "Tarefa [codTarefa=" + codTarefa + ", nome=" + nome + ", status=" + status + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Tarefa tarefa = (Tarefa) o;
		return Objects.equals(codTarefa, tarefa.codTarefa);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codTarefa);
	}
}
