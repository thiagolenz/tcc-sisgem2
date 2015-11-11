package br.com.sisgem.model.utils;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.primefaces.context.RequestContext;

public abstract class BaseBeans implements Serializable {

	private static final long serialVersionUID = -5377726703339445533L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	
	/// Mensagens
//	public void getId() {
//		String id = FacesContext.getCurrentInstance().getExternalContext()
//				.getRequestParameterMap().get("id");
//	}

	public static void showFacesMessage(String texto, int tipo) {
		showFacesMessage(null, texto, tipo);
	}

	public static void showFacesMessage(String id, String texto, int tipo) {
		switch (tipo) {
		case 1:
			FacesContext.getCurrentInstance()
					.addMessage(
							id,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									texto, "Erro"));
			break;
		case 2:
			FacesContext.getCurrentInstance().addMessage(
					id,
					new FacesMessage(FacesMessage.SEVERITY_INFO, texto,
							"Informação"));
			break;
		case 3:
			FacesContext.getCurrentInstance()
					.addMessage(
							id,
							new FacesMessage(FacesMessage.SEVERITY_WARN, texto,
									"Aviso"));
			break;
		case 4:
			FacesContext.getCurrentInstance().addMessage(
					id,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, texto,
							"Fatal"));
			break;
		case 5:
			FacesContext.getCurrentInstance().addMessage(
					id,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, texto,
							"Fatal"));
			break;
		}
	}

	protected String redirect(String outcome) {
		return outcome + "?faces-redirect=true";
	}

	// public FacesContext getFacesContext() {
	// return FacesContext.getCurrentInstance();
	// }
	//
	// public ExternalContext getExternalContext() {
	// return getFacesContext().getExternalContext();
	// }
	//
	// public HttpServletRequest getHttpServletRequest() {
	// return ((HttpServletRequest) getExternalContext().getRequest());
	// }
	//
	// public HttpServletResponse getHttpServletResponse() {
	// return ((HttpServletResponse) getExternalContext().getResponse());
	// }
	public void showDialog(String dialog) {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('" + dialog + "').show();");

	}
	
	public void hideDialog(String dialog) {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('" + dialog + "').hide();");

	}

}
