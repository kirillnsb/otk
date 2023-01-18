package ru.kirillnsb.otk.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "staff")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")

    Long employee_id;
    String login;
    String password;
    String email;

    @OneToMany(mappedBy = "employeeRef")
    private List<Checkup> checkupList;

    public List<Checkup> getCheckupList() {
        return checkupList;
    }
    public void setCheckupList(List<Checkup> checkupList) {
        this.checkupList = checkupList;}


    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(employee_id, user.employee_id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, login, password, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "employee_id=" + employee_id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
