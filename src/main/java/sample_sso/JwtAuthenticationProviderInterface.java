package sample_sso;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface JwtAuthenticationProviderInterface {

    String createToken(String userPk, List<String> roles);

    Authentication getAuthentication(String token);

    String getUserPk(String token);

    String resolveToken(HttpServletRequest request);

    boolean validateToken(String jwtToken);

}
