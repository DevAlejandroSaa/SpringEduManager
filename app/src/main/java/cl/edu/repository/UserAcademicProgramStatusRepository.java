package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.UserAcademicProgramStatus;

public interface UserAcademicProgramStatusRepository extends JpaRepository<UserAcademicProgramStatus, UUID> {

}
