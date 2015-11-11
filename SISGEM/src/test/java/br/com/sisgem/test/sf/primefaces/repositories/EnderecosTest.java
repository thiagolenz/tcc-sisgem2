package br.com.sisgem.test.sf.primefaces.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.sisgem.model.BairrosEntity;
import br.com.sisgem.model.CidadesEntity;
import br.com.sisgem.model.UfEntity;
import br.com.sisgem.model.repository.IBairrosRepository;
import br.com.sisgem.model.repository.ICidadesRepository;
import br.com.sisgem.model.repository.IUfRepository;
import br.com.sisgem.test.jsf.primefaces.AbstractDatabaseTest;

public class EnderecosTest extends AbstractDatabaseTest {
	
	private static final Logger LOGGER= Logger.getLogger(EnderecosTest.class);
	
	@Inject
	private IUfRepository ufRepository;
	private ICidadesRepository cidadesRepository;
	private IBairrosRepository bairrosRepository;
	
	UfEntity ufEntity = new UfEntity();
	CidadesEntity cidadesEntity = new CidadesEntity();
    BairrosEntity bairrosEntity = new BairrosEntity();
	
	
	@Test
	public void testFindTeste(){
	List<UfEntity> ufList = this.ufRepository.findByUf("PR");
	LOGGER.info(ufList);

	}
	
}
