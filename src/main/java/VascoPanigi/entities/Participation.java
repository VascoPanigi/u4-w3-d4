package VascoPanigi.entities;
import VascoPanigi.enums.ParticipationState;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "participation")
public class Participation {
    @Id
    @GeneratedValue
    private UUID participation_id;

    @ManyToOne
    @JoinColumn(name = "individual_id", nullable = false)
    private Individual individual;

    @Column(name = "participation_state")
    @Enumerated(EnumType.STRING)
    private ParticipationState participation_state;

    @ManyToOne
    @JoinColumn(name= "event_id", nullable = false)
    private Event event;

    public Participation(Individual individual, Event event, ParticipationState participation_state) {
        this.individual = individual;
        this.event = event;
        this.participation_state = participation_state;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ParticipationState getParticipation_state() {
        return participation_state;
    }

    public void setParticipation_state(ParticipationState participation_state) {
        this.participation_state = participation_state;
    }

    public UUID getParticipation_id() {
        return participation_id;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "event=" + event +
                ", participation_state=" + participation_state +
                ", individual=" + individual +
                ", participation_id=" + participation_id +
                '}';
    }
}
