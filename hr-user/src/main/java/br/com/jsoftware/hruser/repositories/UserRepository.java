package br.com.jsoftware.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jsoftware.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
