package model;

import java.util.UUID;


public class BaseModel {
    protected UUID id;
    protected String fullName;

    public BaseModel() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
