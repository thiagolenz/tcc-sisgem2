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
@Table(name="formapagamento")
@AttributeOverride(name = "id", column = @Column(name = "idFormaPagamento"))
public class FormapagamentoEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201404140102L;

	@Size(max=40)
	private String Nome;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private EinativoAtivo StatusFP;

	@Size(max=10)
	private Integer Vencimento;
	
	
	
	//----------------------------------MAPEAMENTO----------------------------------------------------------
	
//	@OneToMany(mappedBy="formapagamento_idFormaPagamento", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//	private List<Forma_pagamento_pedido_caixaEntity> formapagamento_idFormaPagamento;
//	
	//------------------------------------------------------------------------------------------------------

	public FormapagamentoEntity() {
		
	}



	public FormapagamentoEntity(String nome, EinativoAtivo statusFP, Integer vencimento) {
		super();
		Nome = nome;
		StatusFP = statusFP;
		Vencimento = vencimento;
	}



	public String getNome() {
		return Nome;
	}



	public void setNome(String nome) {
		Nome = nome;
	}



	public EinativoAtivo getStatusFP() {
		return StatusFP;
	}



	public void setStatusFP(EinativoAtivo statusFP) {
		StatusFP = statusFP;
	}



	public Integer getVencimento() {
		return Vencimento;
	}



	public void setVencimento(Integer vencimento) {
		Vencimento = vencimento;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
