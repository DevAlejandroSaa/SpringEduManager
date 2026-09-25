package cl.edu.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.AccessStatus;

public interface AccessStatusRepository extends JpaRepository<AccessStatus, UUID> {

    Optional<AccessStatus> findByCode(String code);

}
