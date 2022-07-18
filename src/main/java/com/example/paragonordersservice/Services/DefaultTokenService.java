package com.example.paragonordersservice.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class DefaultTokenService implements TokenService{
    @Value("${auth.jwt.secret}")
    private String secretKey;

    @Override
    public boolean checkToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();

        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            System.out.println(decodedJWT.getClaim("role"));
            if (!decodedJWT.getIssuer().equals("auth-service")) {
                System.out.println("Issuer is incorrect");
                log.error("Issuer is incorrect");
                return false;
            }

            if (!decodedJWT.getAudience().contains("paragon")) {
                System.out.println("Audience is incorrect");
                log.error("Audience is incorrect");
                return false;
            }
        } catch (JWTVerificationException e) {
            System.out.println("Token is invalid: " + e.getMessage());
            log.error("Token is invalid: " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public String checkRole(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getClaim("role").asString();
    }
}
