package br.com.sisgem.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.utils.BaseEntities;

@Entity
@Table(name="produtos")
@AttributeOverride(name = "id", column = @Column(name = "idProdutos"))
public class ProdutoEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 1L;
	
	@Size(max=100)
	@NotNull
	private String nome;
	
	@Size(max=40)
	@NotNull
	private String unidade;
	
    @DecimalMax(value= "9999999999.99")
    @NotNull
	private Double valorVenda;
    
    @DecimalMax(value= "9999999999.99")
    @NotNull
	private Double valorCompra;
    
    @Size(max=100)
	private String epi;
    
	@Enumerated(EnumType.STRING)
	@NotNull
	private EinativoAtivo statusProduto;
	
	@ManyToOne
	@JoinColumn(name="Fornecedor_idPessoaJuridica")
	private FornecedorEntity Fornecedor_idPessoaJuridica;
	
	@OneToMany(mappedBy="Produto_idProduto", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<EstoqueUsuarioEntity> EstoqueUsuarioEntity;

	  
	public ProdutoEntity() {
		
	}


	










	public ProdutoEntity(String nome, String unidade, Double valorVenda, Double valorCompra, String epi,
			EinativoAtivo statusProduto, FornecedorEntity fornecedor_idPessoaJuridica,
			List<br.com.sisgem.model.EstoqueUsuarioEntity> estoqueUsuarioEntity) {
		super();
		this.nome = nome;
		this.unidade = unidade;
		this.valorVenda = valorVenda;
		this.valorCompra = valorCompra;
		this.epi = epi;
		this.statusProduto = statusProduto;
		Fornecedor_idPessoaJuridica = fornecedor_idPessoaJuridica;
		EstoqueUsuarioEntity = estoqueUsuarioEntity;
	}













	public List<EstoqueUsuarioEntity> getEstoqueUsuarioEntity() {
		return EstoqueUsuarioEntity;
	}













	public void setEstoqueUsuarioEntity(List<EstoqueUsuarioEntity> estoqueUsuarioEntity) {
		EstoqueUsuarioEntity = estoqueUsuarioEntity;
	}













	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getEpi() {
		return epi;
	}

	public void setEpi(String epi) {
		this.epi = epi;
	}

	public EinativoAtivo getStatusProduto() {
		return statusProduto;
	}

	public void setStatusProduto(EinativoAtivo statusProduto) {
		this.statusProduto = statusProduto;
	}

	public FornecedorEntity getFornecedor_idPessoaJuridica() {
		return Fornecedor_idPessoaJuridica;
	}

	public void setFornecedor_idPessoaJuridica(
			FornecedorEntity fornecedor_idPessoaJuridica) {
		Fornecedor_idPessoaJuridica = fornecedor_idPessoaJuridica;
	}

	
	
}
