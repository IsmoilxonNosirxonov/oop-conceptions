package click.server.database;

import click.server.model.Card;
import click.server.model.History;
import click.server.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Database {
    Map<String, User> USERS = new HashMap<>();
    List<Card> CARDS = new ArrayList<>();
    List<History> HISTORIES = new ArrayList<>();
}
