package br.com.sisgem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sisgem.model.LocalizacaoLogEntity;



@Repository
public interface ILocalizacaoLogRepository extends JpaRepository<LocalizacaoLogEntity, Long>{
	@Query("select p from LocalizacaoLogEntity p where p.DataHora like %?1%")
	public List<LocalizacaoLogEntity> findByAll(String paramLocalizacao);


}
