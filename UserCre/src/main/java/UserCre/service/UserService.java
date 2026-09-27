package UserCre.service;

import java.util.List;

import UserCre.entity.User;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}