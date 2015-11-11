package br.com.sisgem.administrador;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.sisgem.mb.usuario.UsuarioMB;
import br.com.sisgem.model.LocalizacaoLogEntity;
import br.com.sisgem.model.UsuarioEntity;
import br.com.sisgem.model.repository.ILocalizacaoLogRepository;
import br.com.sisgem.model.utils.BaseBeans;
import br.com.sisgem.model.utils.Utilidades;

@Component
@Scope("view")
@Named (value = "localizacaologAddEditMB")
public class LocalizacaoLogAddEditMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ILocalizacaoLogRepository localizacaologRepository;
	
	@Inject
	private FacesContext context;
	
	@Inject
	private LocalizacaoLogMB mbLocalizacaoLogBean;
	
	private UsuarioMB mbUsuarioBean;
	
	private LocalizacaoLogEntity localizacaologObj;
	
	private UsuarioEntity usuarioObj;
	
	private Boolean flagExibeConsultaLocalizacaoLog = true;
	
	private Boolean flagExibeFormularioLocalizacaoLog;
	
	public LocalizacaoLogAddEditMB() {
		this.localizacaologObj = new LocalizacaoLogEntity();
	}
	
	
	public void salvar() {
		try {
			if (this.localizacaologObj != null) {
				if (this.localizacaologObj.getId() == null) {
					// Add
					//this.localizacaologObj.setDataCadastro(new Date());
					this.localizacaologRepository.save(this.localizacaologObj);
				} else {
					// Update
					this.localizacaologRepository.save(this.localizacaologObj);
				}
				Utilidades.showFacesMessage("Salvo com Sucesso", 2);
			}
		} catch (Exception e) {
			Utilidades.showFacesMessage(e.getMessage(), 1);
		}
	}

	public void update(){
		
		this.usuarioObj = mbUsuarioBean.getUsuarioSelecionado();
		hideDialog("dialogListaUsuarios");
		
		//this.mbLocalizacaoLogBean.setFlagBotaoUpdate(true);
		//this.mbLocalizacaoLogBean.setFlagBotaoDelete(true);
	}
	
	
	public void localizacaologVinculado(){
		this.update();
		
		hideDialog("dialogListaLocalizacaoLoges");
	}
	
	public void exibeFormularioLocalizacaoLog() {
		flagExibeFormularioLocalizacaoLog = true;
		flagExibeConsultaLocalizacaoLog = false;
		hideDialog("dialogListaLocalizacaoLoges");
	}
	
	////Getters and Setters////
	public ILocalizacaoLogRepository getLocalizacaoLogRepository() {
		return localizacaologRepository;
	}

	public void setLocalizacaoLogRepository(ILocalizacaoLogRepository localizacaologRepository) {
		this.localizacaologRepository = localizacaologRepository;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public LocalizacaoLogEntity getLocalizacaoLogObj() {
		return localizacaologObj;
	}

	public void setLocalizacaoLogObj(LocalizacaoLogEntity localizacaologObj) {
		this.localizacaologObj = localizacaologObj;
	}


	public Boolean getFlagExibeFormularioLocalizacaoLog() {
		return flagExibeFormularioLocalizacaoLog;
	}


	public void setFlagExibeFormularioLocalizacaoLog(
			Boolean flagExibeFormularioLocalizacaoLog) {
		this.flagExibeFormularioLocalizacaoLog = flagExibeFormularioLocalizacaoLog;
	}


	public Boolean getFlagExibeConsultaLocalizacaoLog() {
		return flagExibeConsultaLocalizacaoLog;
	}


	public void setFlagExibeConsultaLocalizacaoLog(
			Boolean flagExibeConsultaLocalizacaoLog) {
		this.flagExibeConsultaLocalizacaoLog = flagExibeConsultaLocalizacaoLog;
	}

}
