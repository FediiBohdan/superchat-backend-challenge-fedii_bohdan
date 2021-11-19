package ua.fedii.superchat.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contact")
@SQLDelete(sql = "UPDATE contact SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Contact() {}

    public Contact(String name, String email, String login, String password, LocalDateTime updateDate, boolean isDeleted) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.updateDate = updateDate;
        this.isDeleted = isDeleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", updateDate=" + updateDate +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
