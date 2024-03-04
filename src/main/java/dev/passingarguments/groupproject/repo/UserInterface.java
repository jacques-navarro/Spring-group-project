package dev.passingarguments.groupproject.repo;

import dev.passingarguments.groupproject.entity.User;
import jakarta.servlet.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User, Long> {
}
