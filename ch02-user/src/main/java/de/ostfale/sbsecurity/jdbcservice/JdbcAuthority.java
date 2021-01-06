package de.ostfale.sbsecurity.jdbcservice;

import javax.persistence.*;

@Entity
//@Table(name = "authorities")
public class JdbcAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String username;
    private String authority;

    public JdbcAuthority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public JdbcAuthority() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "JdbcAuthority{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
