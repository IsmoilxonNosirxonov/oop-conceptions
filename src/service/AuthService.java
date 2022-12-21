package service;

import model.User;

public class AuthService {
      private static User userList[]=new User[100];

    public boolean login(
            final String username,
            final String password
    ){
        for (User user:userList) {
            if(user!=null){
                if(user.getFullName().equals(user.getFullName()) && user.getPassword().equals(user.getPhoneNumber())){
                    return true;
                }
            }
        }
        return false;
    }
}
