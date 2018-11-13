package br.com.gestensaf.gestensaf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="Entrega")
public class Entrega implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="idEntrega")
	private long idEntrega;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="dataEntrega")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="A data da entrega é uma informação obrigatória a ser preenchida.")
	private Date dataEntrega;

	@Column(name="status")
	private String status;
	
	@Column(name="valor")
	@NumberFormat(pattern="0,00")
	@NotNull(message="O valor é uma informação obrigatória")
	private Double valor;
	
	@Column(name="contato")
	private String contato;
	
	@ManyToOne
	@JoinColumn(name="Endereco_Cep", foreignKey=@ForeignKey(name="ENTREGA_ENDERECO_CEP_FK"))
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name="Funcionario_Cpf", foreignKey=@ForeignKey(name="ENTREGA_FUNCIONARIO_CPF_FK"))
	private Funcionario funcionario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name="Veiculo_Placa", foreignKey=@ForeignKey(name="ENTREGA_VEICULO_PLACA_FK"))
	private Veiculo veiculo;

	public long getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(long idEntrega) {
		this.idEntrega = idEntrega;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
