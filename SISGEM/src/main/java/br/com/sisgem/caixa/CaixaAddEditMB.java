package br.com.sisgem.caixa;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.sisgem.model.CaixaEntity;
import br.com.sisgem.model.repository.ICaixaRepository;
import br.com.sisgem.model.utils.BaseBeans;
import br.com.sisgem.model.utils.Utilidades;

@Component
@Scope("view")
@Named (value = "caixaAddEditMB")
public class CaixaAddEditMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICaixaRepository caixaRepository;
	
	@Inject
	private FacesContext context;
	
	@Inject
	private CaixaMB mbCaixaBean;
	
	private CaixaEntity caixaObj;
	
	private Boolean flagExibeConsultaCaixa = true;
	
	private Boolean flagExibeConsultaCaixaFechar = true;
	
	private Boolean flagExibeFormularioCaixa;
	

	public CaixaAddEditMB() {
		this.caixaObj = new CaixaEntity();
	}
	
	
	public void salvar() {
		try {
			if (this.caixaObj != null) {
				if (this.caixaObj.getId() == null) {
					// Add
					this.caixaRepository.save(this.caixaObj);
				} else {
					// Update
					this.caixaRepository.save(this.caixaObj);
				}
				Utilidades.showFacesMessage("Salvo com Sucesso", 2);
			}
		} catch (Exception e) {
			Utilidades.showFacesMessage(e.getMessage(), 1);
		}
	}

	public void update(){
		this.caixaObj = mbCaixaBean.getCaixaSelecionado();
		this.flagExibeConsultaCaixa = false;
		this.flagExibeFormularioCaixa = false;
		this.mbCaixaBean.setFlagBotaoUpdate(true);
		this.mbCaixaBean.setFlagBotaoDelete(true);
	}
	
	
	public void caixaVinculado(){
		this.update();
		
		hideDialog("dialogListaCaixaes");
	}
	
	public void exibeFormularioCaixa() {
		flagExibeFormularioCaixa = true;
		flagExibeConsultaCaixa = false;
		flagExibeConsultaCaixaFechar = true;
		hideDialog("dialogListaCaixaes");
	}
	
	
	////Getters and Setters////
	
	
	
	public ICaixaRepository getCaixaRepository() {
		return caixaRepository;
	}

	public CaixaMB getMbCaixaBean() {
		return mbCaixaBean;
	}


	public void setMbCaixaBean(CaixaMB mbCaixaBean) {
		this.mbCaixaBean = mbCaixaBean;
	}


	public Boolean getFlagExibeConsultaCaixaFechar() {
		return flagExibeConsultaCaixaFechar;
	}


	public void setFlagExibeConsultaCaixaFechar(Boolean flagExibeConsultaCaixaFechar) {
		this.flagExibeConsultaCaixaFechar = flagExibeConsultaCaixaFechar;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setCaixaRepository(ICaixaRepository caixaRepository) {
		this.caixaRepository = caixaRepository;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public CaixaEntity getCaixaObj() {
		return caixaObj;
	}

	public void setCaixaObj(CaixaEntity caixaObj) {
		this.caixaObj = caixaObj;
	}


	public Boolean getFlagExibeFormularioCaixa() {
		return flagExibeFormularioCaixa;
	}


	public void setFlagExibeFormularioCaixa(
			Boolean flagExibeFormularioCaixa) {
		this.flagExibeFormularioCaixa = flagExibeFormularioCaixa;
	}


	public Boolean getFlagExibeConsultaCaixa() {
		return flagExibeConsultaCaixa;
	}


	public void setFlagExibeConsultaCaixa(
			Boolean flagExibeConsultaCaixa) {
		this.flagExibeConsultaCaixa = flagExibeConsultaCaixa;
	}

}
