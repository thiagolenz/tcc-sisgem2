package br.com.sisgem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sisgem.model.ProdutoEntity;

public interface IProdutoRepository extends JpaRepository<ProdutoEntity, Long>{
	@Query("select p from ProdutoEntity p where p.nome like %?1%")
	public List<ProdutoEntity> findByNome(String paramProduto);
}
