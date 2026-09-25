package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.UserPractice;

public interface UserPracticeRepository extends JpaRepository<UserPractice, UUID> {

}
