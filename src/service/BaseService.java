package service;

import model.Card;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class BaseService {

    protected abstract boolean add(Object object);
    protected abstract Object getById(UUID id);

   static List<Card>cardList=new ArrayList<>();
   static List<User>userList=new ArrayList<>();


}
