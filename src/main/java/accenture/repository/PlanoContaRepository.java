package accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import accenture.model.PlanoConta;

														//model, type id
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long>{
	
}
