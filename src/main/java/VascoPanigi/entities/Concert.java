package VascoPanigi.entities;


import VascoPanigi.enums.ConcertGenres;
import VascoPanigi.enums.EventType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Concert")
public class Concert extends Event{
    private boolean in_streaming;

    @Enumerated(EnumType.STRING)
    protected ConcertGenres concert_genre;

    public Concert(){}

    public Concert(String title, LocalDate event_date, String description, EventType event_type, int max_participants, Location location, boolean in_streaming, ConcertGenres concert_genre) {
        super(title, event_date, description, event_type, max_participants, location);
        this.in_streaming = in_streaming;
        this.concert_genre = concert_genre;
    }

    public boolean isIn_streaming() {
        return in_streaming;
    }

    public void setIn_streaming(boolean in_streaming) {
        this.in_streaming = in_streaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "in_streaming=" + in_streaming +
                "concert_genre=" + concert_genre +
                ", title='" + title + '\'' +
                ", event_date=" + event_date +
                ", description='" + description + '\'' +
                ", event_type=" + event_type +
                ", max_participants=" + max_participants +
                ", location=" + location +
                ", event_id=" + event_id +
                '}';
    }
}
