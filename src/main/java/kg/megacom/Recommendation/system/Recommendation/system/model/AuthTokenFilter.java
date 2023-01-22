package kg.megacom.Recommendation.system.Recommendation.system.model;

import kg.megacom.Recommendation.system.Recommendation.system.exception.JwtAuthenticationException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component

public class AuthTokenFilter extends OncePerRequestFilter {
    private final JwtUtils utils;
    public AuthTokenFilter(JwtUtils utils) {
        this.utils = utils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token =utils.resolveToken(request);
        try {
            if(token !=null && utils.validateToken(token) ){
                Authentication authentication = utils.getAuthentication(token);
                if(authentication !=null){
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }catch (JwtAuthenticationException e){
            SecurityContextHolder.clearContext();
            (response).sendError(e.getHttpStatus().value());
            throw new JwtAuthenticationException("JWT toke is expired or invalid");
        }
        filterChain.doFilter(request,response);
    }
}
