package br.com.sisgem.mb.carro;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.sisgem.model.utils.BaseBeans;
import br.com.sisgem.model.utils.Utilidades;

@Component
@Scope("view")
@Named (value = "carroAddEditMB")
public class CarroAddEditMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
//	@Inject
//	private ICarroRepository carroRepository;
	
	//	@Inject
//	private FacesContext context;
	
//	@Inject
//		private CarroMB mbCarroBean;
	
//	private CarroEntity carroObj;
	
	private Boolean flagExibeConsultaCarro = true;
	
	private Boolean flagExibeFormularioCarro;
	
	public CarroAddEditMB() {
	//	this.carroObj = new CarroEntity();
	}
	
//	public void salvar() {
//		try {
//			if (this.carroObj != null) {
//				if (this.carroObj.getId() == null) {
//					// Add
//					this.carroRepository.save(this.carroObj);
//				} else {
//					// Update
//					this.carroRepository.save(this.carroObj);
//				}
//				Utilidades.showFacesMessage("Salvo com Sucesso", 2);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

//	public void update(){
//		this.carroObj = mbCarroBean.getCarroSelecionado();
//	}
	
//	public void carroVinculado(){
//		this.update();
//		
//		hideDialog("dialogListaResultado");
//	}
	
	public void exibeFormularioCarro() {
		flagExibeFormularioCarro = true;
		flagExibeConsultaCarro = false;
		hideDialog("dialogListaCarros");
	}
	
	////Getters and Setters////
//	public ICarroRepository getFornecedorRepository() {
//		return carroRepository;
//	}
//
//	public void setCarroRepository(ICarroRepository carroRepository) {
//		this.carroRepository = carroRepository;
//	}

	//	public FacesContext getContext() {
	//		return context;
	//	}

	//	public void setContext(FacesContext context) {
	//		this.context = context;
	//	}

//	public CarroEntity getCarroObj() {
//		return carroObj;
//	}
//
//	public void setCarroObj(CarroEntity carroObj) {
//		this.carroObj = carroObj;
//	}


	public Boolean getFlagExibeFormularioCarro() {
		return flagExibeFormularioCarro;
	}

	public void setFlagExibeFormularioCarro(
			Boolean flagExibeFormularioCarro) {
		this.flagExibeFormularioCarro = flagExibeFormularioCarro;
	}

	public Boolean getFlagExibeConsultaCarro() {
		return flagExibeConsultaCarro;
	}

	public void setFlagExibeConsultaCarro(
			Boolean flagExibeConsultaCarro) {
		this.flagExibeConsultaCarro = flagExibeConsultaCarro;
	}

}
