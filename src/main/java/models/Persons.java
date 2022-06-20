package models;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "persons")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Persons implements Serializable {
    public Persons(){}
   private List<Person> person;

    public Persons(List<Person> person) {
        this.person = person;
    }

    @XmlElement
    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }
}

