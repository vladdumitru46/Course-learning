package com.example.repositoryes.user;

import com.example.models.user.User;
import com.example.models.user.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    @Query("SELECT us FROM UserSession us WHERE us.token = :token")
    Optional<UserSession> findByToken(String token);

    @Query("SELECT us FROM UserSession us WHERE us.user = :user")
    Optional<UserSession> findByUser(User user);
}
