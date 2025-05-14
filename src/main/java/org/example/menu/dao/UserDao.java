package org.example.menu.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.example.crudmenu.entity.User;

import java.io.File;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@AllArgsConstructor
public class UserDao {

    private ObjectMapper objectMapper;

    private File file;

    @SneakyThrows
    public List<User> FindAll() {
        return objectMapper.readValue(file, new TypeReference<List<User>>(){});
    }

    @SneakyThrows
    public void save(User user) {
        List<User> users = FindAll();
        users.add(user);
        objectMapper.writeValue(file, users);
    }

    @SneakyThrows
    public void deleteUser(Optional<User> user) {
        List<User> users = FindAll();
        users.remove(user.get());
        objectMapper.writeValue(file, users);
    }

    @SneakyThrows
    public void updatePassword(Optional<User> user) {
        List<User> users = FindAll();
        users.stream()
                .filter(u -> u.getLogin().equals(user.get().getLogin()))
                .findFirst().ifPresent(u -> u.setPassword(user.get().getPassword()));
        objectMapper.writeValue(file,users);
    }
}
