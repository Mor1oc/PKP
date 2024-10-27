package Models;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private String password;
    private Roles role;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean isPassword(String password) {
        if (this.password.equals(password))
            return true;
        return false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
