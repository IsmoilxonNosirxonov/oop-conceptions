package service;

import model.Card;
import model.P2P;
import model.User;

import java.util.UUID;

public abstract class BaseService {

    protected abstract boolean add(Object object);

    protected static Card[] cardList = new Card[500];
    protected static User[] userList = new User[100];
    protected static P2P[] p2pList=new P2P[1000];

}
