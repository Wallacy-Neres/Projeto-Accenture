package accenture.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import accenture.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class TokenAuthorizationFilter extends OncePerRequestFilter {

	private final String HEADER = "Authorization";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		try {
			if (validaJWT(request, response)) {
				Claims claims = decodificaJWT(request);
				if (claims.get("authorities") != null)
					validaAutenticacao(claims);
				else
					SecurityContextHolder.clearContext();
			} else 
				SecurityContextHolder.clearContext();
			chain.doFilter(request, response);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException e) {
			throw e;
		}
	}	

	// decodifica JWT validado
	private Claims decodificaJWT(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(TokenService.JWT_PREFIX, "");
		JwtParser parser = Jwts.parser().setSigningKey(TokenService.KEY.getBytes());
		Jws<Claims> claimsJws;
		try {
			claimsJws = parser.parseClaimsJws(jwtToken);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
			throw e;
		}
		return claimsJws.getBody();
	}

	// valida a autenticação e reinvidação do usuário com o JWT recebido
	private void validaAutenticacao(Claims claims) {
		@SuppressWarnings("unchecked")
		List<String> authorities = (List<String>) claims.get("authorities");

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

	// checa se o JWT recebido via header é válido
	private boolean validaJWT(HttpServletRequest request, HttpServletResponse res) {
		String header = request.getHeader(HEADER);
		return !(header == null || !header.startsWith(TokenService.JWT_PREFIX));
	}
}