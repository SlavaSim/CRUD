package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {
    User save(User user);
    void update(User user);
    void delete(User user);
    List<User> getUserList();
    List<User> getUsersByName(String name);
    User getUser(Integer id);
}
