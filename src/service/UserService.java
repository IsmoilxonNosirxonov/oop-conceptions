package service;

import model.User;

import java.util.UUID;

public class UserService extends BaseService{
    int index=0;
    public static UUID currentUserId=null;
    @Override
    public boolean add(Object object) {
        User user = (User) object;
        for (User u:userList) {
            if(u!=null){
                if(u.getPhoneNumber().equals(user.getPhoneNumber()) && u.getPassword().equals(user.getPassword())){
                    return false;
                }
            }
        }
        userList[index++]=user;
        return true;
    }

    public User login(String phoneNumber,String password) {
        for (User user:userList) {
            if(user!=null){
                if(user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)){
                    currentUserId=user.getId();
                    return user;
                }
            }
        }
        return null;
    }
}
