package service;

import model.Card;

import java.util.UUID;

public class CardService extends BaseService{

    @Override
    protected boolean add(Object object) {
        return false;
    }

    @Override
    protected Object getById(UUID id) {
        return null;
    }

    public Card[] cardList(final UUID userId){

        return null;
    }
}
