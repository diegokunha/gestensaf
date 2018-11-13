package br.com.gestensaf.gestensaf.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Funcionario")
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cpf")
	@CPF
	@NotBlank(message="O cpf é um preenchimento obrigatória.")
	private String cpf;
		
	@Column(name="nome")
	@NotBlank(message="O nome é um preenchimento obrigatória.")
	private String nome;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="dataNasc")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="A data de nascimento é um preenchimento obrigatória.")
	private Date dataNasc;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="celular")
	@NotBlank(message="O celular é um preenchimento obrigatória.")
	private String celular;
	
	@Column(name="email")
	private String email;
	
	@Column(name="funcao")
	@NotBlank(message="A função é um preenchimento obrigatória.")
	private String funcao;
	
	@Column(name="situacao")
	private boolean situacao;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="estadoCivil")
	private String estadoCivil;
	
	@Column(name="mae")
	private String mae;
	
	@Column(name="pai")
	private String pai;
	
	@Column(name="rg")
	private String rg;
	
	@Column(name="emissaoRg")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date emissaoRg;

	@Column(name="orgaoRg")
	private String orgaoRg;
	
	@Column(name="cnh")
	private String cnh;

	@Column(name="registroCnh")
	private String registroCnh;
	
	@Column(name="validadeCnh")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validadeCnh;
	
	@Column(name="categoriaCnh")
	private String categoriaCnh;
	
	@Column(name="obs")
	private String obs;
	
	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	@Size(min=6)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="Endereco_Cep", foreignKey=@ForeignKey(name="ENDERECO_CEP_FK"))
	private Endereco endereco;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getEmissaoRg() {
		return emissaoRg;
	}

	public void setEmissaoRg(Date emissaoRg) {
		this.emissaoRg = emissaoRg;
	}

	public String getOrgaoRg() {
		return orgaoRg;
	}

	public void setOrgaoRg(String orgaoRg) {
		this.orgaoRg = orgaoRg;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getRegistroCnh() {
		return registroCnh;
	}

	public void setRegistroCnh(String registroCnh) {
		this.registroCnh = registroCnh;
	}

	public Date getValidadeCnh() {
		return validadeCnh;
	}

	public void setValidadeCnh(Date validadeCnh) {
		this.validadeCnh = validadeCnh;
	}

	public String getCategoriaCnh() {
		return categoriaCnh;
	}

	public void setCategoriaCnh(String categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	
	
}
