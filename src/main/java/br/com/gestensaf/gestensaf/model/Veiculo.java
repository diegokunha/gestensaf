package br.com.gestensaf.gestensaf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="Veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="placa")
	@NotBlank(message = "A placa é um preenchimento obrigatório.")
	private String placa;
	
	@Column(name="situacao")
	@NotNull(message = "A situação é um preenchimento obrigatório.")
	private boolean situacao; 
	
	@Column(name="status")
	private String status;
	
	@Column(name="obs")
	private String obs;
	
	@Column(name="km")
	@NotNull(message = "A quilometragem é um preenchimento obrigatório.")
	@NumberFormat(pattern="0,00")	
	private Double km;
		
	@Column(name="renavan")
	@NotBlank(message="O renavan é um preenchimento obrigatório.")
	private String renavan;
	
	@Column(name="chassi")
	@NotBlank(message="O chassi é um preenchimento obrigatório.")
	private String chassi;
	
	@Column(name="marca")
	@NotBlank(message="A marca é um preenchimento obrigatório.")
	private String marca;
	
	@Column(name="modelo")
	@NotBlank(message="O modelo é um preenchimento obrigatório.")
	private String modelo;
	
	@Column(name="anoFabricao")
	private int anoFabricao;
	
	@Column(name="anoModelo")
	private int anoModelo;
	
	@Column(name="cor")
	private String cor;
	
	@Column(name="tipoCombustivel")
	private String tipoCombustivel;

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Veiculo)) {
			return false;
		}else {
			final Veiculo orther = (Veiculo) obj;
			return this.getPlaca().equals(orther.getPlaca());			
		}
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public String getRenavan() {
		return renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricao() {
		return anoFabricao;
	}

	public void setAnoFabricao(int anoFabricao) {
		this.anoFabricao = anoFabricao;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getKm() {
		return km;
	}

	public void setKm(Double km) {
		this.km = km;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	
	
}
