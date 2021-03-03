package accenture.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import accenture.model.Usuario;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenService {
	
	public static final String KEY = "usersecret";
	
	public static final String JWT_PREFIX = "Bearer ";

    // expiração de 60 minutos
    private static final long expirationTime = 3200000;

    // gera um JWT para o usuário com os dados da chave KEY
    public String geraToken(Usuario user) {
    	String role = "ROLE_USER";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
    	
        return Jwts.builder()
                .setSubject(user.getLogin())
                .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, KEY.getBytes())
                .compact();
    }

    // decodifica o JWT gerado com os dados da chave KEY
    public Claims decodificaToken(String token) {
        return Jwts.parser()
                .setSigningKey(KEY.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }
}