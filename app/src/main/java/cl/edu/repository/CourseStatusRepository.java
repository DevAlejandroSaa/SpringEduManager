package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.CourseStatus;

public interface CourseStatusRepository extends JpaRepository<CourseStatus, UUID> {

}
