package models;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Person implements Serializable {

    private String firstname, lastname, id, residence, friends;
    public Person(){
        super();
    }
    public Person(String firstname, String lastname, String id, String residence, String friends) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.residence = residence;
        this.friends = friends;
    }
    @XmlElement
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @XmlElement
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @XmlElement
    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    @XmlAttribute
    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }
}
