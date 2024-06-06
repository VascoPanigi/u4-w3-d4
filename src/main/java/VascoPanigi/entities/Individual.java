package VascoPanigi.entities;
import VascoPanigi.enums.IndividualsGender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "individual")
public class Individual {
    @Id
    @GeneratedValue
    private UUID individual_id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private LocalDate birth_date;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private IndividualsGender gender;

    @OneToMany(mappedBy = "individual")
    private List<Participation> participation_list;


    public Individual(String name, String surname, String email, LocalDate birth_date, IndividualsGender gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birth_date = birth_date;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getIndividual_id() {
        return individual_id;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public IndividualsGender getGender() {
        return gender;
    }

    public void setGender(IndividualsGender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "individual_id=" + individual_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birth_date=" + birth_date +
                ", gender=" + gender +
                '}';
    }
}
