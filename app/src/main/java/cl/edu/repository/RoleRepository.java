package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {

}
