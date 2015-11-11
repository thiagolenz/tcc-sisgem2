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
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Temporal;

import br.com.sisgem.model.utils.BaseEntities;

@Entity
@Table(name="caixa")
@AttributeOverride(name = "id", column = @Column(name = "idCaixa"))
public class CaixaEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201404140102L;

	private Double Erro;
	
	@NotNull
	//@Temporal(value=TemporalType.TIMESTAMP)
	private  Date DataAbertura;
	
	//@Temporal(value=TemporalType.TIMESTAMP)
	private  Date  DataFechamento;
	
	public CaixaEntity() {
		
	}

	public CaixaEntity(Double erro, Date dataAbertura, Date dataFechamento) {
		super();
		Erro = erro;
		DataAbertura = dataAbertura;
		DataFechamento = dataFechamento;
	}

	public Double getErro() {
		return Erro;
	}

	public void setErro(Double erro) {
		Erro = erro;
	}

	public java.util.Date getDataAbertura() {
		return DataAbertura;
	}

	public void setDataAbertura(java.util.Date dataAbertura) {
		DataAbertura = dataAbertura;
	}

	public java.util.Date getDataFechamento() {
		return DataFechamento;
	}

	public void setDataFechamento(java.util.Date dataFechamento) {
		DataFechamento = dataFechamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}