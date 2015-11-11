package br.com.sisgem.mb.fornecedor;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.repository.IFornecedorRepository;
import br.com.sisgem.model.utils.BaseBeans;

@Component
@Scope("view")
@Named(value= "fornecedorMB")
public class FornecedorMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Inject
	private IFornecedorRepository fornecedorRepository;
	
	private List<FornecedorEntity> fornecedorList;
	
	private FornecedorEntity fornecedorSelecionado;
	
	private String paramFornecedor;
	
	private boolean flagBotaoUpdate = true;
	
	private boolean flagBotaoDelete = true;
	
	private boolean flagBotaoSelecionarFornecedor = true;
	
	public FornecedorMB() {
		
	}
	
	public void findFornecedor(String paramFornecedor){
		this.setFornecedorList(this.fornecedorRepository.findByCNPJ(paramFornecedor));
		this.paramFornecedor = null;
		showDialog("dialogListaFornecedores");
	}
	
	public void selectFornecedor(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.fornecedorSelecionado = (FornecedorEntity) evt.getObject();
				this.setFlagBotaoDelete(false);
				this.setFlagBotaoUpdate(false);
				this.setFlagBotaoSelecionarFornecedor(false);
		
			} else {
				this.fornecedorSelecionado = null;
			}
		} catch (Exception e) {
			this.fornecedorSelecionado = null;

			logger.error(e.getMessage(), e);
		}
	}
	
	public void unselectFornecedor() {
		this.fornecedorSelecionado = null;
		this.setFlagBotaoUpdate(true);
		this.setFlagBotaoDelete(true);
		this.setFlagBotaoSelecionarFornecedor(true);
	}
	
	public void delete() {
		if (this.fornecedorSelecionado != null) {
			this.fornecedorList.remove(this.fornecedorSelecionado);
			this.fornecedorRepository.delete(this.fornecedorSelecionado.getId());
			unselectFornecedor();
			this.setFlagBotaoUpdate(true);
			this.setFlagBotaoDelete(true);
		}
	}
	
	////Getters and Setters////
	public List<FornecedorEntity> getFornecedorList() {
		return fornecedorList;
	}
	public void setFornecedorList(List<FornecedorEntity> fornecedorList) {
		this.fornecedorList = fornecedorList;
	}
	public FornecedorEntity getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}
	public void setFornecedorSelecionado(FornecedorEntity fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}
	public String getParamFornecedor() {
		return paramFornecedor;
	}
	public void setParamFornecedor(String paramFornecedor) {
		this.paramFornecedor = paramFornecedor;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public IFornecedorRepository getFornecedorRepository() {
		return fornecedorRepository;
	}

	public void setFornecedorRepository(IFornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	public boolean isFlagBotaoUpdate() {
		return flagBotaoUpdate;
	}

	public void setFlagBotaoUpdate(boolean flagBotaoUpdate) {
		this.flagBotaoUpdate = flagBotaoUpdate;
	}

	public boolean isFlagBotaoDelete() {
		return flagBotaoDelete;
	}

	public void setFlagBotaoDelete(boolean flagBotaoDelete) {
		this.flagBotaoDelete = flagBotaoDelete;
	}

	public boolean isFlagBotaoSelecionarFornecedor() {
		return flagBotaoSelecionarFornecedor;
	}

	public void setFlagBotaoSelecionarFornecedor(boolean flagBotaoSelecionarFornecedor) {
		this.flagBotaoSelecionarFornecedor = flagBotaoSelecionarFornecedor;
	}




}
