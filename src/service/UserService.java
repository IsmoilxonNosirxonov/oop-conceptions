package service;

import model.User;

import model.History;
import model.HistoryType;

import java.util.UUID;

public class UserService extends BaseService{

    @Override
    protected boolean add(Object object) {
        return false;
    }

    @Override
    protected Object getById(UUID id) {
        return null;
    }
}
