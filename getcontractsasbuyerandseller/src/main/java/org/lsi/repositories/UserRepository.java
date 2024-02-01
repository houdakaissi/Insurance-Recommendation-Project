package org.lsi.repositories;

import java.util.Optional;

import org.lsi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
      Optional<User> findById(Long id);
}
