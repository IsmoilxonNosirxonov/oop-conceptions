package click.server.dto;

public class UserDto {
    private String phoneNumber;
    private String password;

    public UserDto(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
