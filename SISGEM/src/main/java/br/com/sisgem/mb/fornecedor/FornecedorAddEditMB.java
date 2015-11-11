package br.com.sisgem.mb.fornecedor;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.repository.IFornecedorRepository;
import br.com.sisgem.model.utils.BaseBeans;
import br.com.sisgem.model.utils.Utilidades;

@Component
@Scope("view")
@Named (value = "fornecedorAddEditMB")
public class FornecedorAddEditMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IFornecedorRepository fornecedorRepository;
	
	@Inject
	private FacesContext context;
	
	@Inject
	private FornecedorMB mbFornecedorBean;
	
	private FornecedorEntity fornecedorObj;
	
	private Boolean flagExibeConsultaFornecedor = true;
	
	private Boolean flagExibeFormularioFornecedor;
	
	private String validaCnpj = null;
	
	public FornecedorAddEditMB() {
		this.fornecedorObj = new FornecedorEntity();
	}
	
	
	public void salvar() {
		try {
			if (this.fornecedorObj != null && validaCnpj(this.validaCnpj)) {
				this.fornecedorObj.setCnpj(getValidaCnpj());
				if (this.fornecedorObj.getId() == null) {
					// Add
					this.fornecedorObj.setDataCadastro(new Date());
					this.fornecedorRepository.save(this.fornecedorObj);
				} else {
					// Update
					this.fornecedorRepository.save(this.fornecedorObj);
				}
				Utilidades.showFacesMessage("Salvo com Sucesso", 2);
			}
		} catch (Exception e) {
			Utilidades.showFacesMessage(e.getMessage(), 1);
		}
	}

	public void update(){
		this.fornecedorObj = mbFornecedorBean.getFornecedorSelecionado();
		this.validaCnpj = this.fornecedorObj.getCnpj();
		this.flagExibeConsultaFornecedor = false;
		this.flagExibeFormularioFornecedor = true;
		//hideDialog("dialogListaFornecedores");
		this.mbFornecedorBean.setFlagBotaoUpdate(true);
		this.mbFornecedorBean.setFlagBotaoDelete(true);
	}
	
	
	public void fornecedorVinculado(){
		this.update();
		
		hideDialog("dialogListaFornecedores");
	}
	
	public void exibeFormularioFornecedor() {
		flagExibeFormularioFornecedor = true;
		flagExibeConsultaFornecedor = false;
		hideDialog("dialogListaFornecedores");
	}
	
	public boolean validaCnpj(String cnpj) {
		if (cnpj.isEmpty() || cnpj.equals("__.___.___/____-__")) {
			return true;
		} else if (!cnpj.contains("_")
				&& Utilidades.cpfCnpjisValid(cnpj) == true) {
			if (!fornecedorRepository
					.findByCNPJ(cnpj).isEmpty()) {
				Utilidades.showFacesMessage("CNPJ já Cadastrado", 1);
				return false;
			} else {
				return true;
			}
		} else if (!cnpj.contains("_") && !cnpj.contains("_")
				&& Utilidades.cpfCnpjisValid(cnpj) == false) {
			Utilidades.showFacesMessage("CNPJ Invalido", 1);
			return false;
		}
		return false;
	}
	
	////Getters and Setters////
	public IFornecedorRepository getFornecedorRepository() {
		return fornecedorRepository;
	}

	public void setFornecedorRepository(IFornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public FornecedorEntity getFornecedorObj() {
		return fornecedorObj;
	}

	public void setFornecedorObj(FornecedorEntity fornecedorObj) {
		this.fornecedorObj = fornecedorObj;
	}


	public Boolean getFlagExibeFormularioFornecedor() {
		return flagExibeFormularioFornecedor;
	}


	public void setFlagExibeFormularioFornecedor(
			Boolean flagExibeFormularioFornecedor) {
		this.flagExibeFormularioFornecedor = flagExibeFormularioFornecedor;
	}


	public Boolean getFlagExibeConsultaFornecedor() {
		return flagExibeConsultaFornecedor;
	}


	public void setFlagExibeConsultaFornecedor(
			Boolean flagExibeConsultaFornecedor) {
		this.flagExibeConsultaFornecedor = flagExibeConsultaFornecedor;
	}


	public String getValidaCnpj() {
		return validaCnpj;
	}


	public void setValidaCnpj(String validaCnpj) {
		this.validaCnpj = validaCnpj;
	}

}
