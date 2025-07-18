package com.generation.golady.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
 
@Component
public class JwtService {
 
	public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
 
	// decodifica a chave secreta e retorna a chave de conexão
	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}
 
	// retorna um objeto JSON
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSignKey()).build()
				.parseClaimsJws(token).getBody();
	}
 
	// recebe o token e uma função interna no JWT para mapear o objeto JSON e retornar os dados para acesso
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
 
	// extrai nome do usuario de dentro do token
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	// extrai a data de dentro do token
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
 
	// usa a validade do token para identificar se ele está válido ou não
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
 
	// verifica se o nome de usuário do token é o mesmo recebido pelo userdetails
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
 
	// cria token com username, data e chave
	private String createToken(Map<String, Object> claims, String userName) {
		return Jwts.builder()
					.setClaims(claims)
					.setSubject(userName)
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // configura para o token durar 1h
					.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}
 
	// gera token externo usando o nome de usuário
	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userName);
	}
 
}