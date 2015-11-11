package br.com.sisgem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sisgem.model.CarroEntity;

public interface ICarroRepository extends JpaRepository<CarroEntity, Long>{
	
	@Query("select p from CarroEntity p where p.Placa like %?1%")
	public List<CarroEntity> findByPlaca(String paramCarro);
}
