package com.example.user;

import com.example.models.user.User;
import com.example.models.user.UserSession;
import com.example.repositoryes.user.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("userService")
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserSessionService userSessionService;

    public String getByEmailOrUsernameAndPassword(String emailOrUsername, String password) throws Exception {
        User user = userRepository.findByEmailAndPassword(emailOrUsername, password)
                .orElse(userRepository.findByUsernameAndPassword(emailOrUsername, password)
                        .orElseThrow(() -> new Exception("There is no user with these credentials")));
        String token = generateToken(emailOrUsername);
        try {
            UserSession userSession = userSessionService.getByUser(user);
            userSession.setToken(token);
            userSession.setCratedAt(LocalDateTime.now());
            userSession.setExpiresAt(LocalDateTime.now().plusDays(3));
            userSessionService.update(userSession);
        } catch (Exception e) {
            userSessionService.addSession(new UserSession(user, token, LocalDateTime.now(), LocalDateTime.now().plusDays(3)));
        }
        return token;
    }

    private String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS256, Keys.secretKeyFor(SignatureAlgorithm.HS256))
                .compact();
    }

    public void add(User user) {
        userRepository.save(user);
    }
}
