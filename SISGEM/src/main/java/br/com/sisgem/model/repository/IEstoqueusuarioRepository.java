package br.com.sisgem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sisgem.model.CaixaEntity;
import br.com.sisgem.model.UsuarioEntity;
import br.com.sisgem.model.EstoqueUsuarioEntity;
import br.com.sisgem.model.FormapagamentoEntity;

public interface IEstoqueusuarioRepository extends JpaRepository<EstoqueUsuarioEntity, Long>{

	//@Query("select p from EstoqueUsuarioEntity p where p.usuario.name like %?1%")
	//public List<EstoqueUsuarioEntity> findByEstoque(String paramEstoque);
	
}
