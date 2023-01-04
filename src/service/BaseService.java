package service;

import model.Card;
import model.User;

import java.util.UUID;

public abstract class BaseService {

    protected abstract boolean add(Object object);
    protected abstract Object getById(UUID id);

    public static Card[] cardList = new Card[500];
    public static User[] userList = new User[100];


}
