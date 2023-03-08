package com.ntnu.ivansh.Building.Restful.Api.Users;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int count = 3;

    static {
        users.add(new User(1,"Ivan", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Egor", LocalDate.now().minusYears(10)));
        users.add(new User(3,"Misha", LocalDate.now().minusYears(15)));
    }
    public List<User> findAll(){
        return users;
    }
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId()==id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId()==id;
        users.removeIf(predicate);
    }
    public User save(User user){
        user.setId(++count);
        users.add(user);
        return user;
    }
}
