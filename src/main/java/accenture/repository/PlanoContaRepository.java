package accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import accenture.model.PlanoConta;

import java.util.List;
import java.util.Optional;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long>{

    public List<PlanoConta> findAllByLogin(String login);
}
