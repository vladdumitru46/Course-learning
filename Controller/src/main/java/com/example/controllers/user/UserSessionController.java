package com.example.controllers.user;

import com.example.models.user.UserSession;
import com.example.user.UserSessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.StyledEditorKit;
import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("/userSession")
@CrossOrigin(origins = "*")
public class UserSessionController {

    private final UserSessionService userSessionService;

    @GetMapping("/verifyToken")
    public ResponseEntity<?> verifyIfTokenIsExpired(@RequestParam String token) {
        try {
            UserSession userSession = userSessionService.getByToken(token);
            if (userSession.getExpiresAt().isBefore(LocalDateTime.now())) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
