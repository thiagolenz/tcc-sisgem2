package br.com.sisgem.test.sf.primefaces.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.sisgem.enums.EinativoAtivo;
import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.ProdutoEntity;
import br.com.sisgem.model.repository.IProdutoRepository;
import br.com.sisgem.test.jsf.primefaces.AbstractDatabaseTest;

public class ProdutoTest extends AbstractDatabaseTest {

	private static final Logger LOGGER = Logger.getLogger(ProdutoTest.class);

	@Inject
	private IProdutoRepository produtoRepository;

	@Test
	public void testFindAll() {
		List<ProdutoEntity> produtoList = this.produtoRepository.findAll();
		LOGGER.info(produtoList);
	}

	@Test
	public void testInsertProduto() {
		
		FornecedorEntity fornecedor = new FornecedorEntity();
		
		fornecedor.setId((long) 2);
		
		produtoEntity.setEpi("Mascara");
		produtoEntity.setFornecedor_idPessoaJuridica(fornecedor);
		produtoEntity.setNome("Sabao em po");
		produtoEntity.setStatusProduto(EinativoAtivo.Ativo);
		produtoEntity.setUnidade("Litro");
		produtoEntity.setValorCompra(100.00);
		produtoEntity.setValorVenda(100.00);
		
		this.produtoRepository.save(produtoEntity);
	}

	ProdutoEntity produtoEntity = new ProdutoEntity();
}
