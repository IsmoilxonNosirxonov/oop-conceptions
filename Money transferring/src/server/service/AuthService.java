package server.service;

import server.model.User;

public class AuthService {
    public static User login(String phoneNumber, String password){
        if(phoneNumber==null || password == null || phoneNumber.isBlank() || password.isBlank()){
            return null;
        }
        if(BaseService.USER_MAP.containsKey(phoneNumber)){
            User user = BaseService.USER_MAP.get(phoneNumber);
            if(password.equals(user.getPassword())){
                return user;
            }
            else return null;
        }
        else return null;
    }
}
