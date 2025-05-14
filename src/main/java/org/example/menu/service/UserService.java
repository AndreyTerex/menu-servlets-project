package org.example.menu.service;

import lombok.AllArgsConstructor;
import org.example.crudmenu.dao.UserDao;
import org.example.crudmenu.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class UserService {
    private UserDao userDao;
    private BCryptPasswordEncoder encoder;


    public void save(String login, String password) {

        userDao.save(User.builder()
                .id(UUID.randomUUID())
                .login(login)
                .password(encoder.encode(password))
                .build());
    }
    public Optional<User> findUserByCredentials(String login, String password) {
        List<User> users = userDao.FindAll();
        return users.stream().filter(user -> user.getLogin().equals(login) && encoder.matches(password, user.getPassword())).findFirst();


    }


    public void deleteUser(String Login, String password) {
        if(findUserByCredentials(Login, password).isPresent()) {
            List<User> users = userDao.FindAll();
            Optional<User> user = users.stream().filter(u -> u.getLogin().equals(Login)).findFirst();
            userDao.deleteUser(user);
        }
    }

    public void changePassword(String login, String password, String newPassword) {
        Optional<User> user = findUserByCredentials(login, password);
        user.ifPresent(u -> u.setPassword(encoder.encode(newPassword)));
        userDao.updatePassword(user);
    }

    }

