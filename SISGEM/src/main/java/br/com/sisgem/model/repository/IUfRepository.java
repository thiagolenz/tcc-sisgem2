package br.com.sisgem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.sisgem.model.UfEntity;

public interface IUfRepository extends JpaRepository<UfEntity, Long>{
	@Query("select p from UfEntity p where p.ds_uf_sigla like ?1 ")
//	@Query("select p from UfEntity p where p.ds_uf_sigla like 18 ")
	public List<UfEntity> findByUf(String paramUf);


		
		


}
