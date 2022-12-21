package service;

import model.User;

import java.util.UUID;

public class UserService extends BaseService{

    @Override
    protected boolean add(Object object) {
        User user=(User) object;


        return false;
    }

    @Override
    protected Object getById(UUID id) {
        return null;
    }
}
