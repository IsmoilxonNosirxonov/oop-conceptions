package service;

import model.History;
import model.HistoryType;

import model.User;

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
