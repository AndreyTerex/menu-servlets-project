package org.example.menu.service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.SneakyThrows;
import org.example.crudmenu.entity.LoginAttempt;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class LoginAttemptsService {
    private final Map<String, LoginAttempt> attemptsMap = new ConcurrentHashMap<>();

    public boolean registerLoginAttempt(String login, HttpServletResponse resp){
        LoginAttempt loginAttempt = attemptsMap.computeIfAbsent(login, l -> new LoginAttempt());
        loginAttempt.increment();
        return checkBlock(login,resp);
    }
    @SneakyThrows
    public boolean checkBlock(String login, HttpServletResponse resp){
        LoginAttempt loginAttempt = attemptsMap.get(login);
        if(loginAttempt == null){
            return false;
        }
        if (loginAttempt.getAttempts() > 3 &&
                loginAttempt.getTimeOfAttempt().isBefore(LocalDateTime.now().plusMinutes(5))) {
            return true;
        }

        if (loginAttempt.getTimeOfAttempt().isBefore(LocalDateTime.now().minusMinutes(5))) {
            loginAttempt.reset();
        }
        return false;

    }
    public void resetLoginAttempt(String login){
        attemptsMap.remove(login);
    }
}