package model;

public class User extends BaseModel{
    private String phoneNumber;
    private String fullName;
    private String password;
    private boolean isActive;

    public User(String fullname, String phoneNumber, String password) {
        super();
        this.fullName = fullname;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.isActive = true;
    }
    public User() {
        super();
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
