package accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import accenture.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	@Query("SELECT c FROM Conta c WHERE c.usuario.login = :loginParam AND c.tipoConta = 'CONTA_DEBITO'")
	public Conta findContaDebitoByLogin(@Param("loginParam")String login);

	@Query("SELECT c FROM Conta c WHERE c.usuario.login = :loginParam AND c.tipoConta = 'CONTA_CREDITO'")
	public Conta findContaCreditoByLogin(@Param("loginParam")String login);
}
