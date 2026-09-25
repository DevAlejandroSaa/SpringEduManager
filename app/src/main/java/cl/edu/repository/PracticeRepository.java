package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.Practice;

public interface PracticeRepository extends JpaRepository<Practice, UUID> {

}
