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
@Table(name="carro")
@AttributeOverride(name = "id", column = @Column(name = "idCarro"))
public class CarroEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201404140102L;

	@Size(max=40)
	@NotNull
	private String Modelo;
	
	@Size(max=10)
	private Integer Ano;
	
	@Size(max=40)
	private boolean  Aluguel;
	
	@Size(max=40)
	private String Cor;
	
	@Size(max=40)
	private String Placa;
	
	@Size(max=40)
	private String LocalCarro;
	
	@Enumerated(EnumType.STRING)
	private EinativoAtivo StatusCarro;
	
	//-------------------------Mapeamentos---------------------------------------------------------
	
	@ManyToOne
	@JoinColumn(name="Usuario_idUsuario")
	private UsuarioEntity Usuario_idUsuario;
	
	//---------------------------------------------------------------------------------------------
	public CarroEntity() {
		
	}

	public CarroEntity(String modelo, Integer ano, boolean aluguel, String cor, String placa, String localCarro,
			EinativoAtivo statusCarro, UsuarioEntity usuario_idUsuario) {
		super();
		Modelo = modelo;
		Ano = ano;
		Aluguel = aluguel;
		Cor = cor;
		Placa = placa;
		LocalCarro = localCarro;
		StatusCarro = statusCarro;
		Usuario_idUsuario = usuario_idUsuario;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public Integer getAno() {
		return Ano;
	}

	public void setAno(Integer ano) {
		Ano = ano;
	}

	public boolean isAluguel() {
		return Aluguel;
	}

	public void setAluguel(boolean aluguel) {
		Aluguel = aluguel;
	}

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		Cor = cor;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	public String getLocalCarro() {
		return LocalCarro;
	}

	public void setLocalCarro(String localCarro) {
		LocalCarro = localCarro;
	}

	public EinativoAtivo getStatusCarro() {
		return StatusCarro;
	}

	public void setStatusCarro(EinativoAtivo statusCarro) {
		StatusCarro = statusCarro;
	}

	public UsuarioEntity getUsuario_idUsuario() {
		return Usuario_idUsuario;
	}

	public void setUsuario_idUsuario(UsuarioEntity usuario_idUsuario) {
		Usuario_idUsuario = usuario_idUsuario;
	}

}