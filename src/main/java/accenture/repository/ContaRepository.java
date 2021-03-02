package accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import accenture.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
