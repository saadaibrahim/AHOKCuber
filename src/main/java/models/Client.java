package models;

import javax.persistence.*;

@Entity
public class Client {
    private String id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
