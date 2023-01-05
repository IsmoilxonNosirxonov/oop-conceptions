package server.model;

import java.util.UUID;

public abstract class BaseModel {
    protected UUID id;
    public BaseModel() {
        this.id = UUID.randomUUID();
    }
    public UUID getId() {
        return id;
    }
}
