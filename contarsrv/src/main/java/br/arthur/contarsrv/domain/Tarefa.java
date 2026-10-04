package br.arthur.contarsrv.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tarefa")
public class Tarefa {

	// SimpleDateFormat nao e thread-safe, por isso guardamos so o padrao
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

	@ManyToOne(optional = false)
	@JoinColumn(name = "Sistema_COD_SISTEMA")
	private Sistema sistema;

	@ManyToOne(optional = false)
	@JoinColumn(name = "Agente_COD_AGENTE")
	private Agente agente;

	public Tarefa() {
	}

	public Tarefa(String nome, String descricao, Date dataInicio, String status, Agente agente,
			Sistema sistema) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.status = status;
		this.agente = agente;
		this.sistema = sistema;
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

	/**
	 * Data de inicio no formato aaaa-MM-dd, que e o formato que o input
	 * type="date" do HTML precisa pra vir preenchido na tela de editar.
	 */
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

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
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
