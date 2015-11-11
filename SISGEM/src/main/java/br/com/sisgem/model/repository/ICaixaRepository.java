package br.com.sisgem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sisgem.model.CaixaEntity;
import br.com.sisgem.model.CarroEntity;

public interface ICaixaRepository extends JpaRepository<CaixaEntity, Long>{
	
//	@Query("select p from CaixaEntity p where p.Erro like %?1%")
//	public List<CaixaEntity> findByData(String paramCaixa);


}
