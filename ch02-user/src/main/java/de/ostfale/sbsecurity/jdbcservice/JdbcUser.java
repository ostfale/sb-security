package de.ostfale.sbsecurity.jdbcservice;

import javax.persistence.*;

@Entity
//@Table(name = "users")
public class JdbcUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String username;
    private String password;
    private Integer enabled;

    public JdbcUser(String userName, String password, Integer enabled) {
        this.username = userName;
        this.password = password;
        this.enabled = enabled;
    }

    public JdbcUser() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "JdbcUser{" +
                "Id=" + Id +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
