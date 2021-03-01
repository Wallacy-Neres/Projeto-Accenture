package accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import accenture.model.PlanoConta;

						
@Repository
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long>{
	
}
