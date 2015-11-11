package br.com.sisgem.model;


import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;

import br.com.sisgem.enums.Ecargo;
import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.utils.BaseEntities;

@Entity
@Table(name="usuario")
@AttributeOverride(name = "id", column = @Column(name = "idUsuario"))
public class UsuarioEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201404140102L;


	@Size(max=40)
	private String Celular;
	
	@Size(max=40)
	@Column(name = "Senha")
	@NotNull
	private String password;
	
	@Size(max=40)
	@NotNull
	@Column(name = "Nome")
	private String name;
	
	@Size(max=10)
	@NotNull
	private Integer NumeroEnd;
	
	@Size(max=50)
	@NotNull
	private String CEP;
	
	@Size(max=100)
	private String Telefone;
	
	@Size(max=40)
	private String CelularParticular;
	
	@Size(max=244)
	private String Email;
	
	@Size(max=40)
	private String CMotorista;
	
	@Size(max=40)
	private Date DtaValiCM;
	
	@Size(max=40)
	private String Complemento;
	
	@Size(max=10)
	@NotNull
	private Integer RuasCorreio_idRuasCorreio;	
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Ecargo Cargo;
	
	//----------------Mapeamento para Carro --------------------------
	
	 @OneToMany(mappedBy="Usuario_idUsuario", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<CarroEntity> carroEntity;
	 
	@OneToMany(mappedBy="Usuario_idUsuario", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<LocalizacaoLogEntity> LocalizacaologEntity;

	@OneToMany(mappedBy="Usuario_idUsuario", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<EstoqueUsuarioEntity> EstoqueUsuarioEntity;

	

	 //---------------Mapeamento para pedido-------------------------
	 
	 //@OneToMany(mappedBy="Usuario_idUsuario", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	//	private List<PedidoEntity> pedidoEntity;

	public UsuarioEntity() {
		
	}



	public UsuarioEntity(String celular, String password, String name, Integer numeroEnd, String cEP, String telefone,
			String celularParticular, String email, String cMotorista, Date dtaValiCM, String complemento,
			Integer ruasCorreio_idRuasCorreio, Ecargo cargo, List<CarroEntity> carroEntity,
			List<LocalizacaoLogEntity> localizacaologEntity) {
		super();
		Celular = celular;
		this.password = password;
		this.name = name;
		NumeroEnd = numeroEnd;
		CEP = cEP;
		Telefone = telefone;
		CelularParticular = celularParticular;
		Email = email;
		CMotorista = cMotorista;
		DtaValiCM = dtaValiCM;
		Complemento = complemento;
		RuasCorreio_idRuasCorreio = ruasCorreio_idRuasCorreio;
		Cargo = cargo;
		this.carroEntity = carroEntity;
		LocalizacaologEntity = localizacaologEntity;
	}



	public String getCelular() {
		return Celular;
	}



	public void setCelular(String celular) {
		Celular = celular;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getNumeroEnd() {
		return NumeroEnd;
	}



	public void setNumeroEnd(Integer numeroEnd) {
		NumeroEnd = numeroEnd;
	}



	public String getCEP() {
		return CEP;
	}



	public void setCEP(String cEP) {
		CEP = cEP;
	}



	public String getTelefone() {
		return Telefone;
	}



	public void setTelefone(String telefone) {
		Telefone = telefone;
	}



	public String getCelularParticular() {
		return CelularParticular;
	}



	public void setCelularParticular(String celularParticular) {
		CelularParticular = celularParticular;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getCMotorista() {
		return CMotorista;
	}



	public void setCMotorista(String cMotorista) {
		CMotorista = cMotorista;
	}



	public Date getDtaValiCM() {
		return DtaValiCM;
	}



	public void setDtaValiCM(Date dtaValiCM) {
		DtaValiCM = dtaValiCM;
	}



	public String getComplemento() {
		return Complemento;
	}



	public void setComplemento(String complemento) {
		Complemento = complemento;
	}



	public Integer getRuasCorreio_idRuasCorreio() {
		return RuasCorreio_idRuasCorreio;
	}



	public void setRuasCorreio_idRuasCorreio(Integer ruasCorreio_idRuasCorreio) {
		RuasCorreio_idRuasCorreio = ruasCorreio_idRuasCorreio;
	}


	public Ecargo getCargo() {
		return Cargo;
	}

public String getCargoS(){
	return Cargo.toString();
	
}

	public void setCargo(Ecargo cargo) {
		Cargo = cargo;
	}



	public List<CarroEntity> getCarroEntity() {
		return carroEntity;
	}



	public void setCarroEntity(List<CarroEntity> carroEntity) {
		this.carroEntity = carroEntity;
	}



	public List<LocalizacaoLogEntity> getLocalizacaologEntity() {
		return LocalizacaologEntity;
	}



	public void setLocalizacaologEntity(List<LocalizacaoLogEntity> localizacaologEntity) {
		LocalizacaologEntity = localizacaologEntity;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	
}