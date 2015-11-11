package br.com.sisgem.mb.produto;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.sisgem.mb.fornecedor.FornecedorAddEditMB;
import br.com.sisgem.mb.fornecedor.FornecedorMB;
import br.com.sisgem.model.ProdutoEntity;
import br.com.sisgem.model.repository.IProdutoRepository;
import br.com.sisgem.model.utils.BaseBeans;
import br.com.sisgem.model.utils.Utilidades;

@Component
@Scope ("view")
@Named (value = "produtoAddEditMB")
public class ProdutoAddEditMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProdutoRepository produtoRepository;
	
	@Inject
	private FacesContext context;
	
	@Inject
	private ProdutoMB mbProdutoBean;
	
	@Inject
	private FornecedorMB fornecedor;
	
	@Inject
	private FornecedorAddEditMB fornecedorAddEdit;
	
	public FornecedorAddEditMB getFornecedorAddEdit() {
		return fornecedorAddEdit;
	}

	public void setFornecedorAddEdit(FornecedorAddEditMB fornecedorAddEdit) {
		this.fornecedorAddEdit = fornecedorAddEdit;
	}

	private ProdutoEntity produtoObj;
	
	private Boolean flagExibeConsultaProduto = true;
	
	private Boolean flagExibeFormularioProduto;
	
	private Boolean flagPesquisaFornecedor;
	
	public ProdutoAddEditMB() {
		this.produtoObj = new ProdutoEntity();
	}
	
	
	public void salvar() {
		try {
			if (this.produtoObj != null) {
				if (this.produtoObj.getId() == null) {
					// Add
					this.produtoRepository.save(this.produtoObj);
				} else {
					// Update
					this.produtoRepository.save(this.produtoObj);
				}
				Utilidades.showFacesMessage("Salvo com Sucesso", 2);
			}
		} catch (Exception e) {
			Utilidades.showFacesMessage(e.getMessage(), 1);
		}
	}
	
	
	public void update(){		
		this.produtoObj = mbProdutoBean.getProdutoSelecionado();
		this.produtoObj.setFornecedor_idPessoaJuridica(this.fornecedor.getFornecedorSelecionado());
		this.setFlagExibeConsultaProduto(false);
		this.setFlagExibeFormularioProduto(true);
		hideDialog("dialogListaProduto");
		this.mbProdutoBean.setFlagBotaoUpdate(true);
		this.mbProdutoBean.setFlagBotaoDelete(true);
	}

	public void exibeFormularioProduto() {
//		flagExibeFormularioProduto = true;
		flagExibeConsultaProduto = false;
		flagPesquisaFornecedor = true;
		hideDialog("dialogListaFornecedores");
	}
	
	public void vincularFornecedor(){
		this.produtoObj.setFornecedor_idPessoaJuridica(this.fornecedor.getFornecedorSelecionado());
		flagPesquisaFornecedor = false;
		flagExibeFormularioProduto = true;
		hideDialog("dialogListaFornecedores");
	}
	
//	teste commit
	
	////Getters and Setters////
	public IProdutoRepository getProdutoRepository() {
		return produtoRepository;
	}

	public void setProdutoRepository(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public ProdutoEntity getProdutoObj() {
		return produtoObj;
	}

	public void setProdutoObj(ProdutoEntity produtoObj) {
		this.produtoObj = produtoObj;
	}

	public Boolean getFlagExibeConsultaProduto() {
		return flagExibeConsultaProduto;
	}

	public void setFlagExibeConsultaProduto(Boolean flagExibeConsultaProduto) {
		this.flagExibeConsultaProduto = flagExibeConsultaProduto;
	}

	public Boolean getFlagExibeFormularioProduto() {
		return flagExibeFormularioProduto;
	}

	public void setFlagExibeFormularioProduto(Boolean flagExibeFormularioProduto) {
		this.flagExibeFormularioProduto = flagExibeFormularioProduto;
	}

	public FornecedorMB getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorMB fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Boolean getFlagPesquisaFornecedor() {
		return flagPesquisaFornecedor;
	}

	public void setFlagPesquisaFornecedor(Boolean flagPesquisaFornecedor) {
		this.flagPesquisaFornecedor = flagPesquisaFornecedor;
	}

}
