package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.PracticeStatus;

public interface PracticeStatusRepository extends JpaRepository<PracticeStatus, UUID> {

}
