package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.AcademicProgramStatus;

public interface AcademicProgramStatusRepository extends JpaRepository<AcademicProgramStatus, UUID> {

    boolean existsByCode(String code);

    boolean existsByName(String name);

    boolean existsByCodeAndIdNot(String code, UUID id);

    boolean existsByNameAndIdNot(String name, UUID id);

}
