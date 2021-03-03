package accenture.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accenture.exception.TokenExpiradoException;
import accenture.exception.TokenInvalidoException;
import accenture.model.Usuario;
import accenture.model.UsuarioLogin;
import accenture.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;

@Service
public class AutenticacaoService {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
    
	@Autowired
	private TokenService tokenService;

    public boolean autenticaUsuario(UsuarioLogin dados, String token){
    	Optional<Usuario> user = usuarioRepository.findByLogin(dados.getLogin());
        return (dados.getSenha().equals(user.get().getSenha()) && !token.isEmpty() && validaToken(token));
    }

    public boolean validaToken(String token) {
        try {
            String tokenTratado = token.replace(TokenService.JWT_PREFIX, "");
            Claims claims = tokenService.decodificaToken(tokenTratado);

            //Verifica se o token está expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new TokenExpiradoException();
            return true;
        } catch (TokenExpiradoException et){
            et.printStackTrace();
            throw et;
        } catch (Exception e) {
            e.printStackTrace();
            throw new TokenInvalidoException();
        }
    }
}
