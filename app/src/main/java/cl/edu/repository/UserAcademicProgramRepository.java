package cl.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.UserAcademicProgram;
import cl.edu.entity.UserAcademicProgramId;

public interface UserAcademicProgramRepository extends JpaRepository<UserAcademicProgram, UserAcademicProgramId> {

}
