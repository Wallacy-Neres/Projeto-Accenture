package accenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import accenture.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.email = :emailParam")
	Usuario findByEmail(@Param("emailParam") String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.cpf = :cpfParam")
	Usuario findByCpf(@Param("cpfParam") String cpf);
}
