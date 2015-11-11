package br.com.sisgem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sisgem.model.ClienteEntity;


public interface IClienteRepository extends JpaRepository<ClienteEntity, Long>{
	@Query("select p from ClienteEntity p where p.NomeRazaoS like %?1%")
	public List<ClienteEntity> findByNome(String paramCliente);
}
