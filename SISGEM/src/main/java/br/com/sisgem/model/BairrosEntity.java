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
@Table(name="bairros")
@AttributeOverride(name = "id", column = @Column(name = "cd_bairro"))
public class BairrosEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201404140102L;

	
	@Size(max=244)
	private String  ds_bairro_nome;
		
	@ManyToOne
	@JoinColumn(name="cd_cidade")
	private CidadesEntity cd_cidade;
	
	@OneToMany(mappedBy="cd_bairro", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<LogradourosEntity> LogradourosEntity;	
	
	public BairrosEntity() {
		
	}

	public BairrosEntity(String ds_bairro_nome, CidadesEntity cd_cidade) {
		super();
		this.ds_bairro_nome = ds_bairro_nome;
		this.cd_cidade = cd_cidade;
	}

	public String getDs_bairro_nome() {
		return ds_bairro_nome;
	}

	public void setDs_bairro_nome(String ds_bairro_nome) {
		this.ds_bairro_nome = ds_bairro_nome;
	}

	
	public CidadesEntity getCd_cidade() {
		return cd_cidade;
	}

	public void setCd_cidade(CidadesEntity cd_cidade) {
		this.cd_cidade = cd_cidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}