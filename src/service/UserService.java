package service;

import model.User;

import model.History;
import model.HistoryType;

import java.util.UUID;

public class UserService extends BaseService{
private int index=0;
    @Override
    protected boolean add(Object object) {
        User user = (User) object;
        for (User user1:userList) {
            if(user1!=null){
                if(user1.getFullName().equals(user.getFullName())){
                    return false;
                }
            }
        }
        userList[index++]= user;
        return true;
    }

    @Override
    protected Object getById(UUID id) {
        for (User user : userList) {
            if(user!=null){
                if(user.getId().equals(id)){
                    return user;
                }
            }
        }
        return null;
    }
}
