package de.ostfale.sbsecurity.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Otp {

    @Id
    private String username;
    private String code;

    @Override
    public String toString() {
        return "Otp{" +
                "username='" + username + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Otp otp = (Otp) o;
        return username.equals(otp.username) && code.equals(otp.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, code);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
