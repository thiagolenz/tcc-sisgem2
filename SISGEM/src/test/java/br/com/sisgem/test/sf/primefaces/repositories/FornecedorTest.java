package br.com.sisgem.test.sf.primefaces.repositories;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.repository.IFornecedorRepository;
import br.com.sisgem.test.jsf.primefaces.AbstractDatabaseTest;

public class FornecedorTest extends AbstractDatabaseTest {
	
	private static final Logger LOGGER= Logger.getLogger(FornecedorTest.class);
	
	@Inject
	private IFornecedorRepository fornecedorRepository;
	
	@Test
	public void testFindAll(){
		List<FornecedorEntity> fornecedorList = this.fornecedorRepository.findAll();
		LOGGER.info(fornecedorList);
	}
	
	@Test
	public void testInsertFornecedor(){
		Date d = new Date(); 
			fornecedorEntity.setCep("83320000");
			fornecedorEntity.setCnpj("testeCnpj2");
			fornecedorEntity.setComplemento("testeComplemento");
			fornecedorEntity.setDataCadastro(d);
			fornecedorEntity.setEmail("teste@email");
			fornecedorEntity.setIe("testeaie");
			fornecedorEntity.setIm("testeIM");
			fornecedorEntity.setNomeContato("glaci");
			fornecedorEntity.setNomeFantasia("testeNomeFantasia");
			fornecedorEntity.setNumeroEndereco(10);
			fornecedorEntity.setObservacao("testblob");
			fornecedorEntity.setRazaoSocial("testeRazaoSocial");
			fornecedorEntity.setStatusForn(EinativoAtivo.Ativo);
			fornecedorEntity.setTelefone("testeTelefone");	
			fornecedorEntity.setTelefone2("testeTelefone2");


			
			this.fornecedorRepository.save(fornecedorEntity);
			Long id = fornecedorEntity.getId();

	}
	
	FornecedorEntity fornecedorEntity = new FornecedorEntity();
}
