package cl.edu.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.Access;

public interface AccessRepository extends JpaRepository<Access, UUID> {

    Optional<Access> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<Access> findByUserInformationId(UUID userInformationId);

}
