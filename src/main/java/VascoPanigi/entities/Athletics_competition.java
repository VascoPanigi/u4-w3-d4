package VascoPanigi.entities;


import VascoPanigi.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("Athletics_competition")
public class Athletics_competition extends Event{

//    CREIAMO IL MANY TO MANY TRA ATHLETICS COMPETITION E INDIVIDUALS

@ManyToMany
@JoinTable(
        name = "competition_participants",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name="individual_id")
)
private List<Individual> athletes;

@ManyToOne
@JoinColumn(name="individual_id")
private Individual winner;


//    @OneToMany(mappedBy = "athletics_competition")
//    private List<Individual> athletes;


//    private List<Individual> athletes;


//    @OneToOne
//    @JoinColumn(name = "winner")
//    private Individual winner;

    public Athletics_competition(){}

    public Athletics_competition(String title, LocalDate event_date, String description, EventType event_type, int max_participants, Location location, List<Individual> athletes, Individual winner) {
        super(title, event_date, description, event_type, max_participants, location);
        this.athletes = athletes;
        this.winner = winner;
    }

    public List<Individual> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Individual> athletes) {
        this.athletes = athletes;
    }

    public Individual getWinner() {
        return winner;
    }

    public void setWinner(Individual winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Athletics_competition{" +
                "athletes=" + athletes +
                ", winner=" + winner +
                ", event_id=" + event_id +
                ", title='" + title + '\'' +
                ", event_date=" + event_date +
                ", description='" + description + '\'' +
                ", event_type=" + event_type +
                ", max_participants=" + max_participants +
                ", location=" + location +
                '}';
    }
}
