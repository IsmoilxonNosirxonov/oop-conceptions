package service;

import model.User;

public class AuthService {
    public User[] userList=new User[1000];

    public boolean login(
            final String username,
            final String password
    ){
        for (User user:userList) {
            if(user!=null){
                if(user.getFullName().equals(username) && user.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return  false;

    }
}
