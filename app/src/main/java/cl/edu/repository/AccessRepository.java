package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.Access;

public interface AccessRepository extends JpaRepository<Access, UUID> {

}
