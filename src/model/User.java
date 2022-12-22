package model;

import java.util.UUID;

public class User extends BaseModel{
    private String phoneNumber;
    private String password;
    private UUID userId;
    public User() {
        super();
        this.userId=UUID.randomUUID();
    }

    public User(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
