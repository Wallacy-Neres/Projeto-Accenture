package accenture.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import accenture.DTO.LancamentoDTO;
import accenture.enums.TipoConta;
import accenture.model.Lancamento;
		
@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	@Query("SELECT l FROM Lancamento l WHERE l.conta.usuario.login = :login AND l.data >= :dataInicio and l.data <= :dataFim and l.conta.tipoConta = :tipo")
	List<LancamentoDTO> findByLoginAndDataInicioAndDataFimAndTipo(@Param("login") String login,@Param("dataInicio") Date dataInicio,@Param("dataFim") Date dataFim,@Param("tipo") TipoConta tipoConta);
	
}
