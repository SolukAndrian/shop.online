package ua.lviv.sombra.dto;

/**
 * Created by Apple on 05.04.2017.
 */
public class CustomerDto {
    private String surname;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String login;
    private String password;

    public CustomerDto() {
    }

    public CustomerDto(String surname, String name, String address, String phone, String email, String login, String password) {
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
