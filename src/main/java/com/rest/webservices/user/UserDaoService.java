package com.rest.webservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 5;

    static {
        users.add(new User(1, "Kamran", new Date()));
        users.add(new User(2, "Mehman", new Date()));
        users.add(new User(3, "Turshu", new Date()));
        users.add(new User(4, "Mehemmed", new Date()));
        users.add(new User(5, "Peysember", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
