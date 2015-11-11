package br.com.sisgem.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.utils.BaseEntities;

@Entity
@Table(name="fornecedor")
@AttributeOverride(name = "id", column = @Column(name = "idPessoaJuridica"))
public class FornecedorEntity extends BaseEntities<Long>{

	private static final long serialVersionUID = 1L;
	
	@Size(max=18)
	@NotNull
	private String cnpj;
	
	@Size(max=40)
	private String im;
	
	@Size(max=40)
	@NotNull
	private String ie;

	@Size(max=100)
	@NotNull
	private String razaoSocial;
	
	@Size(max=14)
	@NotNull
	private String telefone;

	@Size(max=14)
	private String telefone2;
	
	@Size(max=40)
	@NotNull
	private String complemento;
	
	@Size(max=100)
	@NotNull
	private String email;
	
	@Size(max=40)
	private String nomeContato;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private EinativoAtivo statusForn;
	
	@Size(max=40)
	@NotNull
	private String nomeFantasia;
	
	@Size(max=10)
	@NotNull
	private String cep;
	
	private int numeroEndereco;	

	@Lob
	@Size(max=65535)
	private String observacao;
	
	public EinativoAtivo getStatusForn() {
		return statusForn;
	}

	public void setStatusForn(EinativoAtivo statusForn) {
		this.statusForn = statusForn;
	}

	private java.util.Date dataCadastro;
	
    @OneToMany(mappedBy="Fornecedor_idPessoaJuridica", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<ProdutoEntity> produtoEntity;
	
	public FornecedorEntity() {
		// TODO Auto-generated constructor stub
	}

	public FornecedorEntity(String cnpj, String im, String ie,
			String razaoSocial, String telefone, String telefone2,
			String complemento, String email, String nomeContato,
			EinativoAtivo statusForn, String nomeFantasia, String cep,
			int numeroEndereco, String observacao, Date dataCadastro,
			List<ProdutoEntity> produtoEntity) {
		super();
		this.cnpj = cnpj;
		this.im = im;
		this.ie = ie;
		this.razaoSocial = razaoSocial;
		this.telefone = telefone;
		this.telefone2 = telefone2;
		this.complemento = complemento;
		this.email = email;
		this.nomeContato = nomeContato;
		this.statusForn = statusForn;
		this.nomeFantasia = nomeFantasia;
		this.cep = cep;
		this.numeroEndereco = numeroEndereco;
		this.observacao = observacao;
		this.dataCadastro = dataCadastro;
		this.produtoEntity = produtoEntity;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIm() {
		return im;
	}

	public void setIm(String im) {
		this.im = im;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public java.util.Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(java.util.Date date) {
		this.dataCadastro = date;
	}

	public List<ProdutoEntity> getProdutoEntity() {
		return produtoEntity;
	}

	public void setProdutoEntity(List<ProdutoEntity> produtoEntity) {
		this.produtoEntity = produtoEntity;
	}

	

}
