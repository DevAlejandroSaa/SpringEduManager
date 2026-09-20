package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.PracticeEvaluation;

public interface PracticeEvaluationRepository extends JpaRepository<PracticeEvaluation, UUID> {

}
