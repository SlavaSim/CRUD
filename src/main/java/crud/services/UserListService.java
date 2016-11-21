package crud.services;

import crud.model.User;

import java.util.List;

public interface UserListService {
    List<User> getUserList();
    List<User> getUsersByName(String name);
    User getUser(Integer id);
    User save(User user);
    void update(User user);
    void delete(User user);
}
