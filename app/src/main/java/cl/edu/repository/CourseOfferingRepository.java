package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.CourseOffering;

public interface CourseOfferingRepository extends JpaRepository<CourseOffering, UUID> {

}
