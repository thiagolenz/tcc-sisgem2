package br.com.sisgem.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.utils.BaseEntities;

@Entity
@Table(name="cliente")
@AttributeOverride(name = "id", column = @Column(name = "idCliente"))
public class ClienteEntity extends BaseEntities<Long>{

	private static final long serialVersionUID = 1L;
	
	@Size(max=40)
	@NotNull
	private String NomeRazaoS ;
	
	@NotNull
	private Integer NumeroEnd;
	
	@Size(max=40)
	@NotNull
	private String Complemento;

	@Size(max=40)
	@NotNull
	private String Telefone;
	
	@Size(max=40)
	@NotNull
	private String Celular;

	@Size(max=40)
	@NotNull
	private String CNPJCPF;
	
	@Size(max=40)
	@NotNull
	private String Email;
	
	private Date DtaAniversario;
	
	@Size(max=40)
	private String IE;
	
	@Size(max=40)
	private String IM;
	
	private Integer FlagPFPJ;
	
	@NotNull
	private Integer ReceberSMS;

	@Size(max=40)
	private String telefone2;
	
	private Integer RuasCorreio_idRuasCorreio;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private EinativoAtivo StatusCliente;
	@Size(max=110)
	private String nomeFantasia;
	
	private String cep;
	private String cidade;
	private String uf;
	private String bairro;
	private String rua;

	private String observacao;
	
	public ClienteEntity() {
		// TODO Auto-generated constructor stub
	}




	public ClienteEntity(String nomeRazaoS, Integer numeroEnd, String complemento, String telefone, String celular,
			String cNPJCPF, String email, Date dtaAniversario, String iE, String iM, Integer flagPFPJ,
			Integer receberSMS, String telefone2, Integer ruasCorreio_idRuasCorreio, EinativoAtivo statusCliente,
			String nomeFantasia) {
		super();
		NomeRazaoS = nomeRazaoS;
		NumeroEnd = numeroEnd;
		Complemento = complemento;
		Telefone = telefone;
		Celular = celular;
		CNPJCPF = cNPJCPF;
		Email = email;
		DtaAniversario = dtaAniversario;
		IE = iE;
		IM = iM;
		FlagPFPJ = flagPFPJ;
		ReceberSMS = receberSMS;
		this.telefone2 = telefone2;
		RuasCorreio_idRuasCorreio = ruasCorreio_idRuasCorreio;
		StatusCliente = statusCliente;
		this.nomeFantasia = nomeFantasia;
	
	}















	public String getNomeFantasia() {
		return nomeFantasia;
	}









	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}









	public String getTelefone2() {
		return telefone2;
	}






	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}






	public String getNomeRazaoS() {
		return NomeRazaoS;
	}



	public void setNomeRazaoS(String nomeRazaoS) {
		NomeRazaoS = nomeRazaoS;
	}



	public Integer getNumeroEnd() {
		return NumeroEnd;
	}



	public void setNumeroEnd(Integer numeroEnd) {
		NumeroEnd = numeroEnd;
	}



	public String getComplemento() {
		return Complemento;
	}



	public void setComplemento(String complemento) {
		Complemento = complemento;
	}



	public String getTelefone() {
		return Telefone;
	}



	public void setTelefone(String telefone) {
		Telefone = telefone;
	}



	public String getCelular() {
		return Celular;
	}



	public void setCelular(String celular) {
		Celular = celular;
	}



	public String getCNPJCPF() {
		return CNPJCPF;
	}



	public void setCNPJCPF(String cNPJCPF) {
		CNPJCPF = cNPJCPF;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public Date getDtaAniversario() {
		return DtaAniversario;
	}



	public void setDtaAniversario(Date dtaAniversario) {
		DtaAniversario = dtaAniversario;
	}



	public String getIE() {
		return IE;
	}



	public void setIE(String iE) {
		IE = iE;
	}



	public String getIM() {
		return IM;
	}



	public void setIM(String iM) {
		IM = iM;
	}



	public Integer getFlagPFPJ() {
		return FlagPFPJ;
	}



	public void setFlagPFPJ(Integer flagPFPJ) {
		FlagPFPJ = flagPFPJ;
	}



	public Integer getReceberSMS() {
		return ReceberSMS;
	}



	public void setReceberSMS(Integer receberSMS) {
		ReceberSMS = receberSMS;
	}



	public Integer getRuasCorreio_idRuasCorreio() {
		return RuasCorreio_idRuasCorreio;
	}



	public void setRuasCorreio_idRuasCorreio(Integer ruasCorreio_idRuasCorreio) {
		RuasCorreio_idRuasCorreio = ruasCorreio_idRuasCorreio;
	}



	public EinativoAtivo getStatusCliente() {
		return StatusCliente;
	}



	public void setStatusCliente(EinativoAtivo statusCliente) {
		StatusCliente = statusCliente;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	


	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}




	public String getCidade() {
		return cidade;
	}




	public void setCidade(String cidade) {
		this.cidade = cidade;
	}




	public String getUf() {
		return uf;
	}




	public void setUf(String uf) {
		this.uf = uf;
	}




	public String getBairro() {
		return bairro;
	}




	public void setBairro(String bairro) {
		this.bairro = bairro;
	}




	public String getRua() {
		return rua;
	}




	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
