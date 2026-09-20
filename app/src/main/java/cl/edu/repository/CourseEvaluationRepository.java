package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.CourseEvaluation;

public interface CourseEvaluationRepository extends JpaRepository<CourseEvaluation, UUID> {

}
