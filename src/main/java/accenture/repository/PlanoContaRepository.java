package accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import accenture.model.PlanoConta;

import java.util.List;

@Repository
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long>{

	@Query("SELECT p FROM PlanoConta p WHERE p.usuario.login = :loginParam")
    public List<PlanoConta> findAllByLogin(@Param("loginParam") String login);
}
