package tancredidangelo.eventManagementBis.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import tancredidangelo.eventManagementBis.exceptionHandling.exceptions.UnauthorizedException;

import java.io.IOException;

@Component
public class AuthFilter extends OncePerRequestFilter {


    /// dependency injection JWT TOOLS
    private final JWTTools jwtTools;

    public AuthFilter(JWTTools jwtTools) {
        this.jwtTools = jwtTools;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException, UnauthorizedException {
        // Get token
        String authToken = request.getHeader("Authorization");

        // check if token null or invalid
        if (authToken == null || !authToken.startsWith("Bearer ")) {
            throw new UnauthorizedException("Token missing or malformed.");
        }

        // remove bearer
        String accessToken = authToken.replace("Bearer ", "");

        // verify token
        this.jwtTools.verifyToken(accessToken);

        // token is OK -> proceed with filtering request to Controllers
        filterChain.doFilter(request,response);
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        // remove protection from endpoints belonging to Log in and Register controllers
        return new AntPathMatcher().match("/auth/**", request.getServletPath());
    }
}
