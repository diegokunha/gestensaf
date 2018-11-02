package br.com.gestensaf.gestensaf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Manutencao")
public class Manutencao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="idManutencao")
	private long idManutencao;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="km")
	private String km;
	
	@Column(name="dataManutencao")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Data é uma informação obrigatória a ser preenchida.")
	private Date dataManutencao;
	
	@Column(name="valor")
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name="Veiculo_Placa", foreignKey=@ForeignKey(name="MAUNTENCAO_VEICULO_PLACA_FK"))
	private Veiculo veiculo;

	public long getIdManutencao() {
		return idManutencao;
	}

	public void setIdManutencao(long idManutencao) {
		this.idManutencao = idManutencao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
