package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.AcademicProgram;

public interface AcademicProgramRepository extends JpaRepository<AcademicProgram, UUID> {

}
