package br.com.sisgem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sisgem.model.CidadesEntity;
import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.UfEntity;

public interface ICidadesRepository extends JpaRepository<CidadesEntity, Long>{
	@Query("select p from CidadesEntity p where p.ds_cidade_nome like ?1")
	public List<CidadesEntity> findByCidades(String paramCidades);
}
