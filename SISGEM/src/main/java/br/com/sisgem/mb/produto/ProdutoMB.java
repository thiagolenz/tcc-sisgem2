package br.com.sisgem.mb.produto;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.sisgem.model.ProdutoEntity;
import br.com.sisgem.model.repository.IProdutoRepository;
import br.com.sisgem.model.utils.BaseBeans;

@Component
@Scope("view")
@Named(value= "produtoMB")
public class ProdutoMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Inject
	private IProdutoRepository produtoRepository;

	
	private List<ProdutoEntity> produtoList;
	
	private ProdutoEntity produtoSelecionado;
	
	private String paramProduto;
	
	private Boolean flagBotaoUpdate = true;
	
	private Boolean flagBotaoDelete = true;
	
	public ProdutoMB() {
		
	}
	
	public void findProduto(String paramProduto){
		this.setProdutoList(this.produtoRepository.findByNome(paramProduto));
		this.paramProduto = null;
		showDialog("dialogListaProduto");
	}
	
	public void selectProduto(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.produtoSelecionado = (ProdutoEntity) evt.getObject();
				this.flagBotaoDelete = false;
				this.flagBotaoUpdate = false;
		
			} else {
				this.produtoSelecionado = null;
			}
		} catch (Exception e) {
			this.produtoSelecionado = null;

			logger.error(e.getMessage(), e);
		}
	}
	
	public void unselectProduto() {
		this.produtoSelecionado = null;
	}
	
	public void delete() {
		if (this.produtoSelecionado != null) {
			this.produtoList.remove(this.produtoSelecionado);
			this.produtoRepository.delete(this.produtoSelecionado.getId());
			unselectProduto();
		}
	}
	
	////Getters and Setters////
	public List<ProdutoEntity> getProdutoList() {
		return produtoList;
	}
	public void setProdutoList(List<ProdutoEntity> produtoList) {
		this.produtoList = produtoList;
	}
	public ProdutoEntity getProdutoSelecionado() {
		return produtoSelecionado;
	}
	public void setProdutoSelecionado(ProdutoEntity produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	public String getParamProduto() {
		return paramProduto;
	}
	public void setParamProduto(String paramProduto) {
		this.paramProduto = paramProduto;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public IProdutoRepository getProdutoRepository() {
		return produtoRepository;
	}

	public void setProdutoRepository(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public Boolean getFlagBotaoUpdate() {
		return flagBotaoUpdate;
	}

	public void setFlagBotaoUpdate(Boolean flagBotaoUpdate) {
		this.flagBotaoUpdate = flagBotaoUpdate;
	}

	public Boolean getFlagBotaoDelete() {
		return flagBotaoDelete;
	}

	public void setFlagBotaoDelete(Boolean flagBotaoDelete) {
		this.flagBotaoDelete = flagBotaoDelete;
	}

}
