package br.com.gestensaf.gestensaf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="Custo")
public class Custo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="idCusto")
	private long idCusto;
	
	@Column(name="KMIni")
	private String kmIni;
	
	@Column(name="KMFim")	
	private String kmFim;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="custoVeiculo")
	@NumberFormat(pattern="0,00")
	private Double custoVeiculo;
	
	@Column(name="custoPedagio")
	@NumberFormat(pattern="0,00")
	private Double custoPedagio;
	
	@Column(name="custoMotorista")
	@NumberFormat(pattern="0,00")
	private Double custoMotorista;
	
	@Column(name="outrosCusto")
	@NumberFormat(pattern="0,00")
	private Double outrosCusto;
	
	@Column(name="custoTotal")
	@NumberFormat(pattern="0,00")
	private Double custoTotal;
		
	@ManyToOne
	@JoinColumn(name="Entrega_IdEntrega", foreignKey=@ForeignKey(name="CUSTO_ENTREGA_IDENTREGA_FK"))
	private Entrega entrega;

	public long getIdCusto() {
		return idCusto;
	}

	public void setIdCusto(long idCusto) {
		this.idCusto = idCusto;
	}

	public String getKmIni() {
		return kmIni;
	}

	public void setKmIni(String kmIni) {
		this.kmIni = kmIni;
	}

	public String getKmFim() {
		return kmFim;
	}

	public void setKmFim(String kmFim) {
		this.kmFim = kmFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public Double getCustoVeiculo() {
		return custoVeiculo;
	}

	public void setCustoVeiculo(Double custoVeiculo) {
		this.custoVeiculo = custoVeiculo;
	}

	public Double getCustoPedagio() {
		return custoPedagio;
	}

	public void setCustoPedagio(Double custoPedagio) {
		this.custoPedagio = custoPedagio;
	}

	public Double getCustoMotorista() {
		return custoMotorista;
	}

	public void setCustoMotorista(Double custoMotorista) {
		this.custoMotorista = custoMotorista;
	}

	public Double getOutrosCusto() {
		return outrosCusto;
	}

	public void setOutrosCusto(Double outrosCusto) {
		this.outrosCusto = outrosCusto;
	}

	public Double getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(Double custoTotal) {
		this.custoTotal = custoTotal;
	}
	
	
	
}
