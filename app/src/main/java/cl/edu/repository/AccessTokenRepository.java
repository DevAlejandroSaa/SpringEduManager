package cl.edu.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.AccessToken;

public interface AccessTokenRepository extends JpaRepository<AccessToken, UUID> {

    Optional<AccessToken> findByToken(String token);

    Optional<AccessToken> findByUserInformationId(UUID userInformationId);

}
