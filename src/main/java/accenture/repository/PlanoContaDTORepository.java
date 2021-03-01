package accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import accenture.model.PlanoConta;
import accenture.model.DTO.PlanoContaDTO;

@Repository
public interface PlanoContaDTORepository extends JpaRepository<PlanoConta, Long> {

}
