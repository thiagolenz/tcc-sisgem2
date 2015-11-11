package br.com.sisgem.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sisgem.model.ClienteEntity;


public interface IClienteRepository extends JpaRepository<ClienteEntity, Long>{


}
