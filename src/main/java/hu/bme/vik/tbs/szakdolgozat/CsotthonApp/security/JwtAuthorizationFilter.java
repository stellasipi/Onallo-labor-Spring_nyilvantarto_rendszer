package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private String jwtSecret;
    private String jwtIssuer;
    private String jwtType;
    private String jwtAudience;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JdbcTemplate jdbcTemplate, String jwtAudience, String jwtIssuer, String jwtSecret, String jwtType) {
        super(authenticationManager);
        //this.jdbcTemplate = jdbcTemplate;
        this.jwtAudience = jwtAudience;
        this.jwtIssuer = jwtIssuer;
        this.jwtSecret = jwtSecret;
        this.jwtType = jwtType;
    }

    private UsernamePasswordAuthenticationToken parseToken(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null && token.startsWith("Bearer ")) {
            String claims = token.replace("Bearer ", "");
            try {
                Jws<Claims> claimsJws = Jwts.parserBuilder()
                        .setSigningKey(jwtSecret.getBytes())
                        .build()
                        .parseClaimsJws(claims);

                String username = claimsJws.getBody().getSubject();

                if ("".equals(username) || username == null) {
                    return null;
                }

                // TODO roles here!
                /*List<SimpleGrantedAuthority> authorities = jdbcTemplate.queryForList(
                        "SELECT a.authority " +
                                "FROM user_authorities a, users u " +
                                "WHERE u.username = ? " +
                                "AND u.id = a.user_id", String.class, username)
                        .stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());*/

                return new UsernamePasswordAuthenticationToken(username, null, null /*TODO: javítani ha lesz role*/);
            } catch (JwtException exception) {
                log.warn("Some exception : {} failed : {}", token, exception.getMessage());
            }
        }

        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authentication = parseToken(request);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }
}
