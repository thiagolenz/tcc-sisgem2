package br.com.sisgem.test.sf.primefaces.repositories;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import br.com.sisgem.model.CaixaEntity;
import br.com.sisgem.model.repository.ICaixaRepository;
import br.com.sisgem.test.jsf.primefaces.AbstractDatabaseTest;

public class CaixaTest extends AbstractDatabaseTest {
	
	private static final Logger LOGGER= Logger.getLogger(CaixaTest.class);
	
	@Inject
	private ICaixaRepository caixaRepository;
	
	@Test
	public void testFindAll(){
		List<CaixaEntity> caixaList = this.caixaRepository.findAll();
		LOGGER.info(caixaList);
	}
//	@Test
//	public void testFindTeste(String paramCaixa){
//		List<CaixaEntity> caixaList = this.caixaRepository.findByData("1.1");
//		LOGGER.info(caixaList);
//	}
	
	
	@Test
	public void testInsertCaixa(){
		Date d = new Date(); 
			caixaEntity.setDataAbertura(d);


			
			this.caixaRepository.save(caixaEntity);
			Long id = caixaEntity.getId();

	}
	
	CaixaEntity caixaEntity = new CaixaEntity();
}
