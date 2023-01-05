package service;

import model.Card;
import model.User;

import java.util.UUID;

public class UserService extends BaseService{


    public static UUID currentUserId;
    private int index = 0;
    @Override
    public boolean add(Object object) {
        User user = (User) object;
        for (User user1 : userList) {
            if(user1 != null){
                if(user1.getFullName().equals(user.getFullName())){
                    return false;
                }
            }
        }
        userList[index++] = user;
        return true;
    }
    public User login(String username, String password){
        for (User user:userList) {
            if(user != null){
                if(user.getFullName().equals(username) && user.getPassword().equals(password)){
                    currentUserId = user.getId();
                    return user;
                }
            }
        }
        return null;
    }
    @Override
    public User getById(UUID id) {
        for (User user : userList) {
            if(user != null){
                if(user.getId().equals(id)){
                    return user;
                }
            }
        }
        return null;
    }
    public boolean blockUser(String fullName){
        for (User user : UserService.userList) {
            if(user != null && user.isActive()){
                if(user.getFullName().equals(fullName)){
                    user.setActive(false);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean unclockUser(String fullName){
        for (User user : UserService.userList) {
            if(user != null && !user.isActive()){
                if(user.getFullName().equals(fullName)){
                    user.setActive(true);
                    return true;
                }
            }
        }
        return false;
    }
}
