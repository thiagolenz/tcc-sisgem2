package br.com.sisgem.caixa;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.sisgem.model.CaixaEntity;
import br.com.sisgem.model.repository.ICaixaRepository;
import br.com.sisgem.model.utils.BaseBeans;

@Component
@Scope("view")
@Named(value= "caixaMB")
public class CaixaMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Inject
	private ICaixaRepository caixaRepository;
	
	private List<CaixaEntity> caixaList;
	
	private CaixaEntity caixaSelecionado;
	
	private String paramCaixa;
	
	private boolean flagBotaoUpdate = true;
	
	private boolean flagBotaoDelete = true;
	
	private boolean flagBotaoSelecionarCaixa = true;
	
	public CaixaMB() {
		
	}
	
	public void findByData(String paramCaixa){
		this.setCaixaList(this.caixaRepository.findAll());
		this.paramCaixa = null;
		showDialog("dialogListaCaixa");
	}
	
	public void selectCaixa(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.caixaSelecionado = (CaixaEntity) evt.getObject();
				this.setFlagBotaoDelete(false);
				this.setFlagBotaoUpdate(false);
				this.setFlagBotaoSelecionarCaixa(false);
		
			} else {
				this.caixaSelecionado = null;
			}
		} catch (Exception e) {
			this.caixaSelecionado = null;

			logger.error(e.getMessage(), e);
		}
	}
	
	public void unselectCaixa() {
		this.caixaSelecionado = null;
		this.setFlagBotaoUpdate(true);
		this.setFlagBotaoDelete(true);
		this.setFlagBotaoSelecionarCaixa(true);
	}
	
	public void delete() {
		if (this.caixaSelecionado != null) {
			this.caixaList.remove(this.caixaSelecionado);
			this.caixaRepository.delete(this.caixaSelecionado.getId());
			unselectCaixa();
			this.setFlagBotaoUpdate(true);
			this.setFlagBotaoDelete(true);
		}
	}
	
	////Getters and Setters////
	public List<CaixaEntity> getCaixaList() {
		return caixaList;
	}
	public void setCaixaList(List<CaixaEntity> caixaList) {
		this.caixaList = caixaList;
	}
	public CaixaEntity getCaixaSelecionado() {
		return caixaSelecionado;
	}
	public void setCaixaSelecionado(CaixaEntity caixaSelecionado) {
		this.caixaSelecionado = caixaSelecionado;
	}
	public String getParamCaixa() {
		return paramCaixa;
	}
	public void setParamCaixa(String paramCaixa) {
		this.paramCaixa = paramCaixa;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public ICaixaRepository getCaixaRepository() {
		return caixaRepository;
	}

	public void setCaixaRepository(ICaixaRepository caixaRepository) {
		this.caixaRepository = caixaRepository;
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

	public boolean isFlagBotaoSelecionarCaixa() {
		return flagBotaoSelecionarCaixa;
	}

	public void setFlagBotaoSelecionarCaixa(boolean flagBotaoSelecionarCaixa) {
		this.flagBotaoSelecionarCaixa = flagBotaoSelecionarCaixa;
	}




}
