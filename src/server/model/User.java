package server.model;
import server.enums.Role;
import server.enums.Status;

public class User extends BaseModel{
    private String phoneNumber;
    private String password;
    private String fullName;
    private Role role;
    private Status status;

    public User(String fullName, String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.fullName = fullName;
        role = Role.USER;
        status = Status.UNBLOCKED;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
