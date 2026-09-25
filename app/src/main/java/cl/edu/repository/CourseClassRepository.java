package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.CourseClass;

public interface CourseClassRepository extends JpaRepository<CourseClass, UUID> {

}
