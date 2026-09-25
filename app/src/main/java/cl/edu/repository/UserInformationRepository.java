package cl.edu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.edu.entity.UserInformation;

public interface UserInformationRepository extends JpaRepository<UserInformation, UUID> {

}
