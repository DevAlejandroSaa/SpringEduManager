package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.GradeRule;

public interface GradeRuleRepository extends JpaRepository<GradeRule, UUID> {

}
