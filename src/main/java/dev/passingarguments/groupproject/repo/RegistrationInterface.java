package dev.passingarguments.groupproject.repo;

import jakarta.servlet.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationInterface extends JpaRepository<Registration, Long> {
}
