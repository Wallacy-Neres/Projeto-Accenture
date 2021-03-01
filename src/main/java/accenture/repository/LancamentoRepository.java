package accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import accenture.model.Lancamento;
														//model, type id
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	
}
