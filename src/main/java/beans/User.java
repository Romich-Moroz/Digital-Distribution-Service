package beans;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private AccessType access;
    private String login;
    private String email;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AccessType getAccess() {
        return access;
    }

    public void setAccess(AccessType access) { this.access = access; }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int id, AccessType access, String login, String email, String password) {
        this.id = id;
        this.access = access;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 97;
        int hash = 1;
        hash = prime * hash + ((login == null) ? 0 : login.hashCode());
        hash = prime * hash + id;
        hash = prime * hash + ((access == null) ? 0 : access.hashCode());
        hash = prime * hash + ((password == null) ? 0 : password.hashCode());
        hash = prime * hash + ((email == null) ? 0 : email.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User inst = (User)obj;
            return inst.id == id && inst.access.equals(access) && inst.login.equals(login) && inst.password.equals(password) && inst.email.equals(email);
        }
        return false;
    }

    @Override
    public String toString() {
        return "User [id =" + id + ", access = " + access.toString() + ", login = " + login + ", email = " + email + ", password = " + password  + "]";
    }

}
