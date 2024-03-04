package dev.passingarguments.groupproject.repo;

import dev.passingarguments.groupproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInterface extends JpaRepository<User, Long> {
    Optional<User> findByUserName(Object unknownAttr1);

    Optional<User> findFirstBy();
}