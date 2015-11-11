package br.com.sisgem.test.sf.primefaces.repositories;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.CarroEntity;
import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.FormapagamentoEntity;
import br.com.sisgem.model.repository.ICarroRepository;
import br.com.sisgem.model.repository.IFormapagamentoRepository;
import br.com.sisgem.model.repository.IUsuarioRepository;
import br.com.sisgem.test.jsf.primefaces.AbstractDatabaseTest;

public class FormapagamentoTest extends AbstractDatabaseTest {
	
	private static final Logger LOGGER= Logger.getLogger(FormapagamentoTest.class);
	
	@Inject
	private IFormapagamentoRepository formapagamentoRepository;
	
	@Test
	public void testFindAll(){
		
		List<FormapagamentoEntity> formapagamentoList = this.formapagamentoRepository.findAll();
		LOGGER.info(formapagamentoList);
	}
	
	
	@Test
	public void testFind(){
		
		List<FormapagamentoEntity> formapagamentoList = this.formapagamentoRepository.findByNome("Dinheiro");
		LOGGER.info(formapagamentoList);
	}
	
	
	@Test
	public void testInsertFormapagamento(){
		Date d = new Date(); 
	
		formapagamentoEntity.setNome("Credito");
		formapagamentoEntity.setStatusFP(EinativoAtivo.Ativo);
		formapagamentoEntity.setVencimento(0);
	
		this.formapagamentoRepository.save(formapagamentoEntity);
		Long id = formapagamentoEntity.getId();
	}
	
	FormapagamentoEntity formapagamentoEntity = new FormapagamentoEntity();
}
