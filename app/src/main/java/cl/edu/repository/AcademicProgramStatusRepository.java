package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.AcademicProgramStatus;

public interface AcademicProgramStatusRepository extends JpaRepository<AcademicProgramStatus, UUID> {

}
