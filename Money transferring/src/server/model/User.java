package server.model;

public class User extends BaseModel{
    private String phoneNumber;
    private String password;
    private String fullName;

    public User(String fullName, String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }
}
