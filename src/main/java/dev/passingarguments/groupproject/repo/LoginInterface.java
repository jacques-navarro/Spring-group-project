package dev.passingarguments.groupproject.repo;

import dev.passingarguments.groupproject.entity.LoginPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginInterface extends JpaRepository<LoginPage, Long> {
}
