package crud.controller;

import crud.model.User;
import crud.services.UserListService;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModelList;

import java.util.List;

@VariableResolver(DelegatingVariableResolver.class)
public class UserViewModel {
    @WireVariable
    UserListService userListService;

    ListModelList<User> userListModel;

    private String nameFilter = "";

    @Init
    public void init() {    // Initialize
        List<User> userList = userListService.getUserList();
        userListModel = new ListModelList<User>(userList);
    }

    public ListModelList<User> getUserListModel() {
        return userListModel;
    }

    public String getNameFilter() {
        return nameFilter;
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }

    @Command
    public void addUser(){
        User user  = userListService.save(new User());
        userListModel.add(user);
    }

    @Command
    public void onChangeAdmin(@BindingParam("user") User user, @BindingParam("checked") boolean checked){
        user.setAdmin(checked);
        userListService.update(user);
    }

    @Command
    public void onChangeName(@BindingParam("user") User user, @BindingParam("name") String name){
        user.setName(name);
        userListService.update(user);
    }

    @Command
    public void onChangeAge(@BindingParam("user") User user, @BindingParam("age") int age){
        user.setAge(age);
        userListService.update(user);
    }

    @Command
    public void deleteUser(@BindingParam("user") User user){
        userListService.delete(user);
        userListModel.remove(user);
    }

    @Command
    @NotifyChange({"userListModel"})
    public void onChangeFilter() {
        List<User> userList = userListService.getUsersByName(nameFilter);
        userListModel = new ListModelList<User>(userList);
    }
}
