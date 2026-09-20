package cl.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.UserRole;
import cl.edu.entity.UserRoleId;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {

}
