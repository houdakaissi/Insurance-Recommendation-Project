package org.lsi.repository;

import java.util.Optional;

import org.lsi.entities.Token;
import org.lsi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Boolean existsByUser(User user);
    Optional<Token> findByUser(User user);
    Optional<Token> findByUserAndToken(User user, String token);
    Optional<Token> findByToken(String token);
}
