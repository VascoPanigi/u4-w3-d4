package VascoPanigi.entities;

import VascoPanigi.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "event_type")
public class Event {
    @Id
    @GeneratedValue
    protected UUID event_id;

    @Column(name = "title")
    protected String title;

    @Column(name = "event_date")
    protected LocalDate event_date;

    @Column(name = "description")
    protected String description;

    @Column(name = "event_type", insertable=false, updatable=false)
    @Enumerated(EnumType.STRING)
    protected EventType event_type;

    @Column(name = "max_participants")
    protected int max_participants;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    protected Location location;

    @ManyToMany(mappedBy = "event")
    protected List<Participation> participation_list;

    public Event() {
    }


    public Event(String title, LocalDate event_date, String description, EventType event_type, int max_participants, Location location) {
        this.title = title;
        this.event_date = event_date;
        this.description = description;
        this.event_type = event_type;
        this.max_participants = max_participants;
        this.location = location;
    }


    public UUID getEvent_id() {
        return event_id;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getMax_participants() {
        return max_participants;
    }

    public void setMax_participants(int max_participants) {
        this.max_participants = max_participants;
    }

    public EventType getEvent_type() {
        return event_type;
    }

    public void setEvent_type(EventType event_type) {
        this.event_type = event_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {
        this.event_date = event_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Event{" +
                "max_participants=" + max_participants +
                ", event_type=" + event_type +
                ", description='" + description + '\'' +
                ", event_date=" + event_date +
                ", title='" + title + '\'' +
                ", event_id=" + event_id +
                '}';
    }
}
