package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.Course;

public interface CourseRepository extends JpaRepository<Course, UUID> {

}
