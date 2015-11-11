package br.com.sisgem.test.sf.primefaces.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.sisgem.model.LocalizacaoLogEntity;
import br.com.sisgem.model.UsuarioEntity;
import br.com.sisgem.model.repository.ILocalizacaoLogRepository;
import br.com.sisgem.test.jsf.primefaces.AbstractDatabaseTest;

public class LocalizacaoLogTest extends AbstractDatabaseTest {

	private static final Logger LOGGER = Logger.getLogger(LocalizacaoLogTest.class);

	@Inject
	private ILocalizacaoLogRepository localizacaologRepository;

	@Test
	public void testFindAll() {
		List<LocalizacaoLogEntity> LocalizacaoLogList = this.localizacaologRepository.findAll();
		LOGGER.info(LocalizacaoLogList);
	}

	@Test
	public void testInsertLocalizacao() {
		
		UsuarioEntity usuario = new UsuarioEntity();
		
		usuario.setId((long) 1);
			
		localizacaologEntity.setUsuario_idUsuario(usuario);
		localizacaologEntity.setLatitude("-99.4771375");
		localizacaologEntity.setLongitude("-99.2580232");
					
		this.localizacaologRepository.save(localizacaologEntity);
	}

	LocalizacaoLogEntity localizacaologEntity = new LocalizacaoLogEntity();
}
