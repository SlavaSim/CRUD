package crud.services;

import crud.dao.UserDao;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userListService")
@Scope(value="singleton",proxyMode= ScopedProxyMode.TARGET_CLASS)
public class UserListServiceImpl implements UserListService{

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUserList() {
        return userDao.getUserList();
    }

    public List<User> getUsersByName(String name) {
        return userDao.getUsersByName(name);
    }

    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    public User save(User user) {
        return userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }
}
