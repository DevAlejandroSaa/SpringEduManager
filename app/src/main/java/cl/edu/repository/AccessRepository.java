package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.Access;

public interface AccessRepository extends JpaRepository<Access, UUID> {

    boolean existsByUsername(String username);

    boolean existsByUserInformationId(UUID userInformationId);

    boolean existsByUsernameAndIdNot(String username, UUID id);

    boolean existsByUserInformationIdAndIdNot(UUID userInformationId, UUID id);

}
