package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.UserCourse;

public interface UserCourseRepository extends JpaRepository<UserCourse, UUID> {

}
