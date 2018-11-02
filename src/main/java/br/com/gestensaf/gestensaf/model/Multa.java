package br.com.gestensaf.gestensaf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Multa")
public class Multa {

	@Id
	@Column(name="codMulta")
	private String codMulta;
	
	@Column(name="numInfracao")
	private int numInfracao;
	
	@Column(name="valor")
	private Double valor;
	
	@Column(name="DataMulta")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataMulta;
	
	@Column(name="HoraMulta")
	private String horaMulta;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="status")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="Endereco_Cep", foreignKey=@ForeignKey(name="MULTA_ENDERECO_CEP_FK"))
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name="Funcionario_Cpf", foreignKey=@ForeignKey(name="MULTA_FUNCIONARIO_CPF_FK"))
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name="Veiculo_Placa", foreignKey=@ForeignKey(name="MULTA_VEICULO_PLACA_FK"))
	private Veiculo veiculo;

	
	public String getCodMulta() {
		return codMulta;
	}

	public void setCodMulta(String codMulta) {
		this.codMulta = codMulta;
	}

	public int getNumInfracao() {
		return numInfracao;
	}

	public void setNumInfracao(int numInfracao) {
		this.numInfracao = numInfracao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataMulta() {
		return dataMulta;
	}

	public void setDataMulta(Date dataMulta) {
		this.dataMulta = dataMulta;
	}

	public String getHoraMulta() {
		return horaMulta;
	}

	public void setHoraMulta(String horaMulta) {
		this.horaMulta = horaMulta;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
