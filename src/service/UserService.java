package service;

import model.User;

import java.util.UUID;

public class UserService extends BaseService{
    private int index = 0;
    @Override
    protected boolean add(Object object) {
        User user = (User) object;
        for (User u:AuthService.userList) {
            if(u != null){
                if(u.getFullName().equals(user.getFullName()){
                    return false;
                }
            }
        }
        AuthService.userList[index++] = user;
        return true;
    }

    @Override
    protected Object getById(UUID id) {
        return null;
    }
}
