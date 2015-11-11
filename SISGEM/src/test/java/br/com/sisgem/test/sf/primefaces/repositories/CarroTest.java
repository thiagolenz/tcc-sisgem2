package br.com.sisgem.test.sf.primefaces.repositories;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.CarroEntity;
import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.UsuarioEntity;
import br.com.sisgem.model.repository.ICarroRepository;
import br.com.sisgem.model.repository.IUsuarioRepository;
import br.com.sisgem.test.jsf.primefaces.AbstractDatabaseTest;

public class CarroTest extends AbstractDatabaseTest {
	
	private static final Logger LOGGER= Logger.getLogger(CarroTest.class);
	
	@Inject
	private ICarroRepository carroRepository;
	
	@Test
	public void testFindAll(){
		List<CarroEntity> carroList = this.carroRepository.findAll();
		LOGGER.info(carroList);
	}
	
	@Test
	public void testInsertCarro(){
		Date d = new Date(); 
			
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setId((long) 1);
		
		carroEntity.setAluguel(true);
		carroEntity.setUsuario_idUsuario(usuario);
		carroEntity.setAno(2015);
		carroEntity.setCor("Preto");
		carroEntity.setLocalCarro("Curitiba");
		carroEntity.setModelo("Fusca");
		carroEntity.setPlaca("PLA0969");
		carroEntity.setStatusCarro(EinativoAtivo.Ativo);
		
		//carroEntity.setUsuario_idUsuario(2);
		
	
		this.carroRepository.save(carroEntity);
		Long id = carroEntity.getId();

	}
	
	CarroEntity carroEntity = new CarroEntity();

}

