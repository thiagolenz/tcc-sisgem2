package br.com.sisgem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sisgem.model.FormapagamentoEntity;
import br.com.sisgem.model.FormapagamentoEntity;

public interface IFormapagamentoRepository extends JpaRepository<FormapagamentoEntity, Long>{

	@Query("select p from FormapagamentoEntity p where p.Nome like %?1%")
	public List<FormapagamentoEntity> findByNome(String paramFormapagamento);

}
