package br.com.sisgem.mb.carro;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import br.com.sisgem.model.utils.BaseBeans;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value= "carroMB")
public class CarroMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(getClass());
	
//	@Inject
//	private ICarroRepository carroRepository;
	
//	private List<CarroEntity> carroList;
	
//	private CarroEntity carroSelecionado;
	
//	private String paramCarro;
	
	private Boolean flagBotaoUpdate = true;
	
	private Boolean flagBotaoDelete = true;
	
	public CarroMB() {
		
	}
	
	public void findCarro(){
//		this.setCarroList(this.carroRepository.findByCarro(paramCarro));
//		this.paramCarro = null;
		showDialog("dialogListaResultado");
	}
	
//	public void selectCarro(SelectEvent evt) {
//		try {
//			if (evt.getObject() != null) {
//				this.carroSelecionado = (CarroEntity) evt.getObject();
//				this.flagBotaoDelete = false;
//				this.flagBotaoUpdate = false;
//		
//			} else {
//				this.carroSelecionado = null;
//			}
//		} catch (Exception e) {
//			this.carroSelecionado = null;
//
//			logger.error(e.getMessage(), e);
//		}
//	}
//	
//	public void unselectCarro() {
//		this.carroSelecionado = null;
//	}
//	
//	public void delete() {
//		if (this.carroSelecionado != null) {
//			this.carroList.remove(this.carroSelecionado);
//			this.carroRepository.delete(this.carroSelecionado.getId());
//			unselectCarro();
//		}
//	}
//	
//	////Getters and Setters////
//	public List<CarroEntity> getCarroList() {
//		return carroList;
//	}
//	public void setCarroList(List<CarroEntity> carroList) {
//		this.carroList = carroList;
//	}
//	public CarroEntity getCarroSelecionado() {
//		return carroSelecionado;
//	}
//	public void setCarroSelecionado(CarroEntity carroSelecionado) {
//		this.carroSelecionado = carroSelecionado;
//	}
//	public String getParamCarro() {
//		return paramCarro;
//	}
//	public void setParamCarro(String paramCarro) {
//		this.paramCarro = paramCarro;
//	}
//	public Logger getLogger() {
//		return logger;
//	}
//	public void setLogger(Logger logger) {
//		this.logger = logger;
//	}
//
//	public ICarroRepository getCarroRepository() {
//		return carroRepository;
//	}
//
//	public void setCarroRepository(ICarroRepository carroRepository) {
//		this.carroRepository = carroRepository;
//	}
//
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
