package br.com.sisgem.mb.cliente;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import br.com.sisgem.model.ClienteEntity;
import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.repository.IClienteRepository;
import br.com.sisgem.model.repository.IFornecedorRepository;
import br.com.sisgem.model.utils.BaseBeans;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value= "clienteMB")
public class ClienteMB extends BaseBeans{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Inject
	private IClienteRepository clienteRepository;
	
	private List<ClienteEntity> clienteList;
	
	private ClienteEntity clienteSelecionado;
	
	private String paramCliente;
	
	private Boolean flagBotaoUpdate = true;
	
	private Boolean flagBotaoDelete = true;
	
	public ClienteMB() {
		
	}
	
	public void findCliente(String paramCliente){
	//	this.setClienteList(this.clienteRepository.findByNome(paramCliente));
		this.paramCliente = null;
		showDialog("dialogListaResultado");
		
	System.out.println("Aqui");
	}
	
	public void selectCliente(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.clienteSelecionado = (ClienteEntity) evt.getObject();
				this.flagBotaoDelete = false;
				this.flagBotaoUpdate = false;
		
			} else {
				this.clienteSelecionado = null;
			}
		} catch (Exception e) {
			this.clienteSelecionado = null;

			logger.error(e.getMessage(), e);
		}
	}
	
	public void unselectCliente() {
		this.clienteSelecionado = null;
	}
	
	public void delete() {
		if (this.clienteSelecionado != null) {
			this.clienteList.remove(this.clienteSelecionado);
			this.clienteRepository.delete(this.clienteSelecionado.getId());
			unselectCliente();
		}
	}
	
	////Getters and Setters////
	public List<ClienteEntity> getClienteList() {
		return clienteList;
	}
	public void setClienteList(List<ClienteEntity> clienteList) {
		this.clienteList = clienteList;
	}
	public ClienteEntity getClienteSelecionado() {
		return clienteSelecionado;
	}
	public void setClienteSelecionado(ClienteEntity clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	public String getParamCliente() {
		return paramCliente;
	}
	public void setParamCliente(String paramCliente) {
		this.paramCliente = paramCliente;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public IClienteRepository getClienteRepository() {
		return clienteRepository;
	}

	public void setClienteRepository(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
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
