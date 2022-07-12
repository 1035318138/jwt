package com.jwt.util;

import com.alibaba.fastjson.JSON;
import com.jwt.dto.TokenVO;
import com.jwt.exception.ErrorCode;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;


/**
 * @author Can.Ru
 */
@Slf4j
@Component
public class JWTUtil {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private  String secretKey;

    @Value("${security.jwt.token.expire-length:3600000}")
    private  long validityInMilliseconds;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public  String createToken(TokenVO vo) {

        Claims claims = Jwts.claims().setSubject(JSON.toJSONString(vo));

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()//
                .setClaims(claims)//
                .setIssuedAt(now)//
                .setExpiration(validity)//
                .signWith(SignatureAlgorithm.HS256, secretKey)//
                .compact();
    }

    public  Jws<Claims> validateToken(String token) throws ErrorCode {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
    }

}
