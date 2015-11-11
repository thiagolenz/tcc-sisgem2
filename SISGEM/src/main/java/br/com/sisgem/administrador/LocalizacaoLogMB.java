package br.com.sisgem.administrador;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import br.com.sisgem.model.LocalizacaoLogEntity;
import br.com.sisgem.model.repository.ILocalizacaoLogRepository;
import br.com.sisgem.model.utils.BaseBeans;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value= "localizacaologMB")
public class LocalizacaoLogMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Inject
	private ILocalizacaoLogRepository localizacaologRepository;
	
	private List<LocalizacaoLogEntity> localizacaologList;
	
	private LocalizacaoLogEntity localizacaologSelecionado;
	
	private String paramLocalizacaoLog;
	
	private boolean flagBotaoUpdate = true;
	
	private boolean flagBotaoDelete = true;
	
	public LocalizacaoLogMB() {
		
	}
	
	public void findLocalizacaoLog(String paramLocalizacaoLog){
		this.setLocalizacaoLogList(this.localizacaologRepository.findByAll(paramLocalizacaoLog));
		this.paramLocalizacaoLog = null;
		showDialog("dialogListaLocalizacaoLog");
	}
	
	public void selectLocalizacaoLog(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.localizacaologSelecionado = (LocalizacaoLogEntity) evt.getObject();
				this.setFlagBotaoDelete(false);
				this.setFlagBotaoUpdate(false);
		
			} else {
				this.localizacaologSelecionado = null;
			}
		} catch (Exception e) {
			this.localizacaologSelecionado = null;

			logger.error(e.getMessage(), e);
		}
	}
	
	public void unselectLocalizacaoLog() {
		this.localizacaologSelecionado = null;
		this.setFlagBotaoUpdate(true);
		this.setFlagBotaoDelete(true);
	}
	
	public void delete() {
		if (this.localizacaologSelecionado != null) {
			this.localizacaologList.remove(this.localizacaologSelecionado);
			this.localizacaologRepository.delete(this.localizacaologSelecionado.getId());
			unselectLocalizacaoLog();
			this.setFlagBotaoUpdate(true);
			this.setFlagBotaoDelete(true);
		}
	}
	
	////Getters and Setters////
	public List<LocalizacaoLogEntity> getLocalizacaoLogList() {
		return localizacaologList;
	}
	public void setLocalizacaoLogList(List<LocalizacaoLogEntity> localizacaologList) {
		this.localizacaologList = localizacaologList;
	}
	public LocalizacaoLogEntity getLocalizacaoLogSelecionado() {
		return localizacaologSelecionado;
	}
	public void setLocalizacaoLogSelecionado(LocalizacaoLogEntity localizacaologSelecionado) {
		this.localizacaologSelecionado = localizacaologSelecionado;
	}
	public String getParamLocalizacaoLog() {
		return paramLocalizacaoLog;
	}
	public void setParamLocalizacaoLog(String paramLocalizacaoLog) {
		this.paramLocalizacaoLog = paramLocalizacaoLog;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public ILocalizacaoLogRepository getLocalizacaoLogRepository() {
		return localizacaologRepository;
	}

	public void setLocalizacaoLogRepository(ILocalizacaoLogRepository localizacaologRepository) {
		this.localizacaologRepository = localizacaologRepository;
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
