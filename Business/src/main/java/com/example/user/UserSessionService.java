package com.example.user;

import com.example.models.user.User;
import com.example.models.user.UserSession;
import com.example.repositoryes.user.UserSessionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("userSession")
@AllArgsConstructor
public class UserSessionService {

    private final UserSessionRepository userSessionRepository;

    public void addSession(UserSession userSession) {
        userSessionRepository.save(userSession);
    }

    public UserSession getByToken(String token) throws Exception {
        return userSessionRepository.findByToken(token)
                .orElseThrow(() -> new Exception("There is no session with this token"));
    }
    public UserSession getByUser(User user) throws Exception {
        return userSessionRepository.findByUser(user)
                .orElseThrow(() -> new Exception("There is no session for this user"));
    }

    @Transactional
    public void update(UserSession userSession) {
        userSession.setToken(userSession.getToken());
    }
}
