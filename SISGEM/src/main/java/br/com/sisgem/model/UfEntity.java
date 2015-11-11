package br.com.sisgem.model;


import java.util.Date;
import java.util.List;
import java.util.ListIterator;

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
@Table(name="uf")
@AttributeOverride(name = "id", column = @Column(name = "cd_uf"))
public class UfEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201404140102L;

	@Size(max=40)
	@NotNull
	private String ds_uf_sigla;
	
	@Size(max=40)
	private String  ds_uf_nome;
		
	@OneToMany(mappedBy="cd_uf", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<CidadesEntity> cidadesEntity;	
	
	public UfEntity() {
		
	}


	public UfEntity(String ds_uf_sigla, String ds_uf_nome, List<CidadesEntity> cidadesEntity) {
		super();
		this.ds_uf_sigla = ds_uf_sigla;
		this.ds_uf_nome = ds_uf_nome;
		this.cidadesEntity = cidadesEntity;
	}


	public String getDs_uf_sigla() {
		return ds_uf_sigla;
	}

	public void setDs_uf_sigla(String ds_uf_sigla) {
		this.ds_uf_sigla = ds_uf_sigla;
	}

	public String getDs_uf_nome() {
		return ds_uf_nome;
	}

	public void setDs_uf_nome(String ds_uf_nome) {
		this.ds_uf_nome = ds_uf_nome;
	}

	public List<CidadesEntity> getCidadesEntity() {
		return cidadesEntity;
	}

	public void setCidadesEntity(List<CidadesEntity> cidadesEntity) {
		this.cidadesEntity = cidadesEntity;
   }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}