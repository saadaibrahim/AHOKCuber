package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

enum Gender {
    Male,
    Female
}

@Entity
@Table(name = "client")
public class Client implements Serializable {
    private String id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;

    private String password;
    private Gender gender;

    private enum Gender {
        MALE (0){
            @Override
            public boolean isMale() {
                return true;
            }
        },
        FEMALE (1){
            @Override
            public boolean isFemale() {
                return true;
            }
        };

        public int sex;

        public boolean isMale() {return false;}

        public boolean isFemale() {return false;}

        Gender (int sex) {
            this.sex = sex;
        }
    }

    public Client() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastname) {
        this.last_name = lastname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firstname) {
        this.first_name = firstname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone) {
        this.phone_number = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
