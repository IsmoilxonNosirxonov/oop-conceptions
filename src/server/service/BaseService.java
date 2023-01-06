package server.service;

import server.model.Card;
import server.model.History;
import server.model.User;

import java.util.*;

public interface BaseService {
    Map<String, Card> CARD_MAP = new HashMap<>();
    Map<String, User> USER_MAP = new HashMap<>();
    List<History> history = new ArrayList<>();

}
