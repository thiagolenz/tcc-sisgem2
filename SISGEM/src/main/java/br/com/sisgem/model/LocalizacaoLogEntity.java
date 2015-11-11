package br.com.sisgem.model;


import javax.persistence.AttributeOverride;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import br.com.sisgem.model.utils.BaseEntities;

@Entity
@Table(name="localizacaolog")
@AttributeOverride(name = "id", column = @Column(name = "idLocalizacaoLog"))
public class LocalizacaoLogEntity extends BaseEntities<Long>{

	private static final long serialVersionUID = 1L;
	
	@Size(max=18)
	private String Latitude;
	
	@Size(max=40)
	private String Longitude;
	
	private java.util.Date DataHora;

	@ManyToOne
	@JoinColumn(name="Usuario_idUsuario")
	private UsuarioEntity Usuario_idUsuario;

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	
	public java.util.Date getDataHora() {
		return DataHora;
	}

	public void setDataHora(java.util.Date dataHora) {
		DataHora = dataHora;
	}

	public UsuarioEntity getUsuario_idUsuario() {
		return Usuario_idUsuario;
	}

	public void setUsuario_idUsuario(UsuarioEntity usuario_idUsuario) {
		Usuario_idUsuario = usuario_idUsuario;
	}
	
	
	
	
}
