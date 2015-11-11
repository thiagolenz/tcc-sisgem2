package br.com.sisgem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sisgem.model.BairrosEntity;
import br.com.sisgem.model.CidadesEntity;
import br.com.sisgem.model.FornecedorEntity;
import br.com.sisgem.model.UfEntity;

public interface IBairrosRepository extends JpaRepository<BairrosEntity, Long>{
	@Query("select p from BairrosEntity p where p.ds_bairro_nome like ?1%")
	public List<BairrosEntity> findByBairros(String paramBairros);

}
