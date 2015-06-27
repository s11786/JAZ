package szympan.jaz.entity;

import java.util.ArrayList;
import java.util.List;

public class User extends Entity {

    private String name;
    private String surname;
    private String mail;
    private String password;
    private Role role;
    private String employer;
    private String source;
    private String hobby;
    private List<Integer> addresses;

    public User() {
        this.addresses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    
    public void addAddress(int id){
        this.addresses.add(id);
    }
    
    public void removeAddress(int id){
        this.addresses.remove(id);
    }

    public List<Integer> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", surname=" + surname + ", mail="
                + mail + ", password=" + password + ", role=" + role
                + ", employer=" + employer + ", source=" + source + ", hobby=" + hobby + '}';
    }

}
