package com.example.demo.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Token;
import com.example.demo.models.User;

public interface TokenRepository extends JpaRepository<Token, Long> {
	Boolean existsByUser(User user);
	Optional<Token> findByUser(User user);
}
