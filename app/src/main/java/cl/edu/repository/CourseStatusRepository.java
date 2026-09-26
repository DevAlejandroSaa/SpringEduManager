package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.CourseStatus;

public interface CourseStatusRepository extends JpaRepository<CourseStatus, UUID> {

    boolean existsByCode(String code);

    boolean existsByName(String name);

    boolean existsByCodeAndIdNot(String code, UUID id);

    boolean existsByNameAndIdNot(String name, UUID id);

}
