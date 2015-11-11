package br.com.sisgem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.utils.BaseEntities;

@Entity
@Table(name="produtosestoque")
@AttributeOverride(name = "id", column = @Column(name = "idProdutosEstoque"))
public class EstoqueUsuarioEntity extends BaseEntities<Long>{

	private static final long serialVersionUID = 1L;
	
	
	@Size(max=10)
	@NotNull
	private Integer Quantidade;

	@ManyToOne
	@JoinColumn(name="Usuario_idUsuario")
	private UsuarioEntity Usuario_idUsuario;
	
	@ManyToOne
	@JoinColumn(name="Produtos_idProdutos")
	private ProdutoEntity Produto_idProduto;

	
public EstoqueUsuarioEntity() {
		
	}






public EstoqueUsuarioEntity(Integer quantidade, UsuarioEntity usuario_idUsuario, ProdutoEntity produto_idProduto) {
	super();
	Quantidade = quantidade;
	Usuario_idUsuario = usuario_idUsuario;
	Produto_idProduto = produto_idProduto;
}






public Integer getQuantidade() {
	return Quantidade;
}


public void setQuantidade(Integer quantidade) {
	Quantidade = quantidade;
}


public UsuarioEntity getUsuario_idUsuario() {
	return Usuario_idUsuario;
}


public void setUsuario_idUsuario(UsuarioEntity usuario_idUsuario) {
	Usuario_idUsuario = usuario_idUsuario;
}


public ProdutoEntity getProduto_idProduto() {
	return Produto_idProduto;
}


public void setProduto_idProduto(ProdutoEntity produto_idProduto) {
	Produto_idProduto = produto_idProduto;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}
	
	
	
	
}
