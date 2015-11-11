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
@Table(name="cidades")
@AttributeOverride(name = "id", column = @Column(name = "cd_cidade"))
public class CidadesEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201404140102L;

	
	@Size(max=40)
	private String  ds_cidade_nome;
		
	@ManyToOne
	@JoinColumn(name="cd_uf")
	private UfEntity cd_uf;
	
	@OneToMany(mappedBy="cd_cidade", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<BairrosEntity> bairrosEntity;	
	
	public CidadesEntity() {
		
	}

	public CidadesEntity(String ds_cidade_nome, UfEntity cd_uf, List<BairrosEntity> bairrosEntity) {
		super();
		this.ds_cidade_nome = ds_cidade_nome;
		this.cd_uf = cd_uf;
		this.bairrosEntity = bairrosEntity;
	}

	public String getDs_cidade_nome() {
		return ds_cidade_nome;
	}

	public void setDs_cidade_nome(String ds_cidade_nome) {
		this.ds_cidade_nome = ds_cidade_nome;
	}

	public UfEntity getCd_uf() {
		return cd_uf;
	}

	public void setCd_uf(UfEntity cd_uf) {
		this.cd_uf = cd_uf;
	}

	public List<BairrosEntity> getBairrosEntity() {
		return bairrosEntity;
	}

	public void setBairrosEntity(List<BairrosEntity> bairrosEntity) {
		this.bairrosEntity = bairrosEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}