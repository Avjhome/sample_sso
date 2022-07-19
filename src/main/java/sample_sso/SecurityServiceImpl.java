package sample_sso;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConstants;
import java.security.Key;
import java.util.Date;

@Service
public class SecurityServiceImpl implements SecurityService{

    private static final String secretKey = "eetet";

    @Override
    public String createtoken(String subject, long ttlMillis) {
        if(ttlMillis == 0 ){
            throw new RuntimeException("토큰 만료기간은 0 이상 이어야 합니다.");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKetSeBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKetSeBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .signWith(signatureAlgorithm, signingKey);

        long nowMillis = System.currentTimeMillis();
        builder.setExpiration(new Date(nowMillis + ttlMillis));
        return builder.compact();
    }

    @Override
    public String getSubject(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
