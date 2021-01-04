package de.ostfale.sbsecurity.user;


import javax.persistence.Entity;
import javax.persistence.Id;

// separate responsibilities
@Entity
public class EntityUser {

    @Id
    private int Id;
    private String userName;
    private String password;
    private String authority;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authoriy) {
        this.authority = authoriy;
    }
}
