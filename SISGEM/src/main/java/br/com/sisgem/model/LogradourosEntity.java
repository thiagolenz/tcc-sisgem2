package br.com.sisgem.model;


import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sisgem.enums.Ecargo;
import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.utils.BaseEntities;

@Entity
@Table(name="logradouros")
@AttributeOverride(name = "id", column = @Column(name = "CD_LOGRADOURO"))
public class LogradourosEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201404140102L;

	
	@Size(max=244)
	private String DS_LOGRADOURO_NOME;;
		
	@ManyToOne
	@JoinColumn(name="CD_BAIRRO")
	private BairrosEntity cd_bairro;
	
	
	@Size(max=10)
	private Integer CD_TIPO;
	
	@Size(max=10)
	private Integer CD_TIPO_LOGRADOUROS;
	
	@Size(max=10)
	private Integer NO_LOGRADOURO_CEP;
	

	
	
	public LogradourosEntity() {
		
	}




	public LogradourosEntity(String dS_LOGRADOURO_NOME, BairrosEntity cd_bairro, Integer cD_TIPO,
			Integer cD_TIPO_LOGRADOUROS, Integer nO_LOGRADOURO_CEP) {
		super();
		DS_LOGRADOURO_NOME = dS_LOGRADOURO_NOME;
		this.cd_bairro = cd_bairro;
		CD_TIPO = cD_TIPO;
		CD_TIPO_LOGRADOUROS = cD_TIPO_LOGRADOUROS;
		NO_LOGRADOURO_CEP = nO_LOGRADOURO_CEP;
	}




	public String getDS_LOGRADOURO_NOME() {
		return DS_LOGRADOURO_NOME;
	}




	public void setDS_LOGRADOURO_NOME(String dS_LOGRADOURO_NOME) {
		DS_LOGRADOURO_NOME = dS_LOGRADOURO_NOME;
	}




	public BairrosEntity getCd_bairro() {
		return cd_bairro;
	}




	public void setCd_bairro(BairrosEntity cd_bairro) {
		this.cd_bairro = cd_bairro;
	}




	public Integer getCD_TIPO() {
		return CD_TIPO;
	}




	public void setCD_TIPO(Integer cD_TIPO) {
		CD_TIPO = cD_TIPO;
	}




	public Integer getCD_TIPO_LOGRADOUROS() {
		return CD_TIPO_LOGRADOUROS;
	}




	public void setCD_TIPO_LOGRADOUROS(Integer cD_TIPO_LOGRADOUROS) {
		CD_TIPO_LOGRADOUROS = cD_TIPO_LOGRADOUROS;
	}




	public Integer getNO_LOGRADOURO_CEP() {
		return NO_LOGRADOURO_CEP;
	}




	public void setNO_LOGRADOURO_CEP(Integer nO_LOGRADOURO_CEP) {
		NO_LOGRADOURO_CEP = nO_LOGRADOURO_CEP;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}