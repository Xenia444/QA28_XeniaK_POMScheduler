package dto;

public class AuthTest {
    String email;
    String password;

    public AuthTest withEmail(String email) {
        this.email = email;
        return this;
    }

    public AuthTest withPassword(String password) {
        this.password = password;
        return this;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
