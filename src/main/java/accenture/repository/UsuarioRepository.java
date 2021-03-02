package accenture.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import accenture.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByLogin(String usuario);
	
	@Query("SELECT u FROM Usuario u WHERE u.login = :loginParam")
	public Usuario findByUserLogin(@Param("loginParam") String login);
	
	//@Query("SELECT u FROM Usuario u WHERE u.email = :emailParam")
	//Usuario findByEmail(@Param("emailParam") String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.cpf = :cpfParam")
	Usuario findByCpf(@Param("cpfParam") String cpf);
}
