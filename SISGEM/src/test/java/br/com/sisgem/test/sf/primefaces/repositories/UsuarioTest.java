package br.com.sisgem.test.sf.primefaces.repositories;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.junit.Test;

import br.com.sisgem.enums.Ecargo;
import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.UsuarioEntity;
import br.com.sisgem.model.repository.IFornecedorRepository;
import br.com.sisgem.model.repository.IUsuarioRepository;
import br.com.sisgem.test.jsf.primefaces.AbstractDatabaseTest;

public class UsuarioTest extends AbstractDatabaseTest {
	
	private static final Logger LOGGER= Logger.getLogger(UsuarioTest.class);
	
	@Inject
	private IUsuarioRepository usuarioRepository;
	
	@Test
	public void findParametro(){
		UsuarioEntity usuarioList = this.usuarioRepository.findByNameAndPassword("1","1");
		LOGGER.info(usuarioList);
	}
	
	@Test
	public void testFindAll(){
		List<UsuarioEntity> usuarioList = this.usuarioRepository.findAll();
		LOGGER.info(usuarioList);
	}
	
	@Test
	public void testInsertUsuario(){
		Date d = new Date(); 
		
		usuarioEntity.setDtaValiCM(d);
		usuarioEntity.setEmail("teste@email");
		usuarioEntity.setCargo(Ecargo.Administrador);
		usuarioEntity.setCelular("9999-9999");
		usuarioEntity.setPassword("123456");
		usuarioEntity.setCEP("13125123");
		usuarioEntity.setCelularParticular("9999-9999");
		usuarioEntity.setName("glaci");
		usuarioEntity.setEmail("glaci@sisgem.com.br");		
		usuarioEntity.setNumeroEnd(82);
		usuarioEntity.setComplemento("Casa");
		usuarioEntity.setTelefone("999-99999");
		usuarioEntity.setCMotorista("546231854");
		usuarioEntity.setRuasCorreio_idRuasCorreio(1);

			
			this.usuarioRepository.save(usuarioEntity);
			Long id = usuarioEntity.getId();
//			PessoaJuridicaFornecedorEntity fornecedorInserido = this.fornecedorRepository.findOne(id);
			
//			LOGGER.info(fornecedorInserido);
	}
	
	UsuarioEntity usuarioEntity = new UsuarioEntity();
}
