package br.com.sisgem.vendas;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.repository.IFornecedorRepository;
import br.com.sisgem.model.utils.BaseBeans;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value= "pdvMB")
public class PdvMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Inject
	private IFornecedorRepository pdvRepository;
	
	private List<FornecedorEntity> pdvList;
	
	private FornecedorEntity pdvSelecionado;
	
	private String paramFornecedor;
	
	private boolean flagBotaoUpdate = true;
	
	private boolean flagBotaoDelete = true;
	
	public PdvMB() {
		
	}
	
	public void findFornecedor(String paramFornecedor){
		this.setFornecedorList(this.pdvRepository.findByCNPJ(paramFornecedor));
		this.paramFornecedor = null;
		showDialog("dialogListaResultado");
	}
	
	public void selectFornecedor(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.pdvSelecionado = (FornecedorEntity) evt.getObject();
				this.setFlagBotaoDelete(false);
				this.setFlagBotaoUpdate(false);
		
			} else {
				this.pdvSelecionado = null;
			}
		} catch (Exception e) {
			this.pdvSelecionado = null;

			logger.error(e.getMessage(), e);
		}
	}
	
	public void unselectFornecedor() {
		this.pdvSelecionado = null;
		this.setFlagBotaoUpdate(true);
		this.setFlagBotaoDelete(true);
	}
	
	public void delete() {
		if (this.pdvSelecionado != null) {
			this.pdvList.remove(this.pdvSelecionado);
			this.pdvRepository.delete(this.pdvSelecionado.getId());
			unselectFornecedor();
			this.setFlagBotaoUpdate(true);
			this.setFlagBotaoDelete(true);
		}
	}
	
	////Getters and Setters////
	public List<FornecedorEntity> getFornecedorList() {
		return pdvList;
	}
	public void setFornecedorList(List<FornecedorEntity> pdvList) {
		this.pdvList = pdvList;
	}
	public FornecedorEntity getFornecedorSelecionado() {
		return pdvSelecionado;
	}
	public void setFornecedorSelecionado(FornecedorEntity pdvSelecionado) {
		this.pdvSelecionado = pdvSelecionado;
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
		return pdvRepository;
	}

	public void setFornecedorRepository(IFornecedorRepository pdvRepository) {
		this.pdvRepository = pdvRepository;
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




}
