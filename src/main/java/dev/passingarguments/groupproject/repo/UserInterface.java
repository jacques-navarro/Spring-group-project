package dev.passingarguments.groupproject.repo;

import dev.passingarguments.groupproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInterface extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);

}