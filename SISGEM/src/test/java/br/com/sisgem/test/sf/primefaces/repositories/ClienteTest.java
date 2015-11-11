package br.com.sisgem.test.sf.primefaces.repositories;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.omg.PortableInterceptor.ClientRequestInterceptor;

import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.ClienteEntity;
import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.repository.IClienteRepository;
import br.com.sisgem.test.jsf.primefaces.AbstractDatabaseTest;

public class ClienteTest extends AbstractDatabaseTest {
	
	private static final Logger LOGGER= Logger.getLogger(ClienteTest.class);
	
	@Inject
	private IClienteRepository clienteRepository;
	
	@Test
	public void testFindAll(){
		List<ClienteEntity> clienteList = this.clienteRepository.findAll();
		LOGGER.info(clienteList);
	}
	
	//teste de inserção no banco
	@Test
	public void testInsertCliente(){
		Date d = new Date();
	
		clienteEntity.setCelular("99816487");
		clienteEntity.setCNPJCPF("7253426500");
		clienteEntity.setComplemento("casa");
		clienteEntity.setEmail("maria.torres@gmail.com");
		clienteEntity.setFlagPFPJ(1);
		clienteEntity.setIE("1234");
		clienteEntity.setIM("898878");
		clienteEntity.setNomeRazaoS("condor");
		clienteEntity.setNumeroEnd(500);
		clienteEntity.setReceberSMS(1);
		clienteEntity.setTelefone("34250809");
		clienteEntity.setDtaAniversario(d);
		clienteEntity.setRuasCorreio_idRuasCorreio(1);
		
			this.clienteRepository.save(clienteEntity);
			Long id = clienteEntity.getId();
			
//			PessoaJuridicaFornecedorEntity fornecedorInserido = this.fornecedorRepository.findOne(id);
//			LOGGER.info(fornecedorInserido);
	}
	
	ClienteEntity clienteEntity = new ClienteEntity();
}
