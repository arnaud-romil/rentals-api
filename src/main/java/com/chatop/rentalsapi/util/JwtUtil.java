package com.chatop.rentalsapi.util;

import com.chatop.rentalsapi.model.dto.response.TokenResponseDTO;
import com.chatop.rentalsapi.model.entity.User;
import java.time.Instant;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

  private final JwtEncoder jwtEncoder;

  public JwtUtil(JwtEncoder jwtEncoder) {
    this.jwtEncoder = jwtEncoder;
  }

  public TokenResponseDTO generateToken(User user) {
    Instant now = Instant.now();
    long expiry = 3600L;

    JwtClaimsSet claims =
        JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiry))
            .subject(user.getEmail())
            .claim("scope", "")
            .build();

    return new TokenResponseDTO(
        this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
  }
}
