package br.com.sisgem.test.sf.primefaces.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.EstoqueUsuarioEntity;
import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.ProdutoEntity;
import br.com.sisgem.model.UsuarioEntity;
import br.com.sisgem.model.repository.IEstoqueusuarioRepository;
import br.com.sisgem.model.repository.IProdutoRepository;
import br.com.sisgem.test.jsf.primefaces.AbstractDatabaseTest;

public class EstoqueUsuarioTest extends AbstractDatabaseTest {

	private static final Logger LOGGER = Logger.getLogger(EstoqueUsuarioTest.class);

	@Inject
	private IEstoqueusuarioRepository estoqueusuarioRepository;

	@Test
	public void testFindAll() {
		List<EstoqueUsuarioEntity> estoqueusuarioList = this.estoqueusuarioRepository.findAll();
		LOGGER.info(estoqueusuarioList);
	}
	
//	@Test
//	public void testFind() {
//		List<EstoqueUsuarioEntity> estoqueusuarioList = this.estoqueusuarioRepository.findByEstoque("1");
//		LOGGER.info(estoqueusuarioList);
//	}


	
	@Test
	public void testInsertProdutoEstoque() {
		
		ProdutoEntity produto = new ProdutoEntity();
		produto.setId((long) 6);
		
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setId((long) 1);
		
		estoqueusuarioEntity.setQuantidade(1);
		estoqueusuarioEntity.setUsuario_idUsuario(usuario);
		estoqueusuarioEntity.setProduto_idProduto(produto);
		
		this.estoqueusuarioRepository.save(estoqueusuarioEntity);
	}

	EstoqueUsuarioEntity estoqueusuarioEntity = new EstoqueUsuarioEntity();
}
