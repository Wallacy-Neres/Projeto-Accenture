package accenture.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import accenture.model.PlanoConta;

														//model, type id
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long>{
	
}
