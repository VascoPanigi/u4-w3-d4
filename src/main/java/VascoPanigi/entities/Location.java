package VascoPanigi.entities;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    private UUID location_id;

    @Column(name = "location_name")
    private String location_name;

    @Column(name = "location_city")
    private String location_city;

    //just one location for many events daje
    @OneToMany(mappedBy = "location")
    private List<Event> event_list;

    public Location(String location_name, String location_city) {
        this.location_name = location_name;
        this.location_city = location_city;
    }

    public UUID getLocation_id() {
        return location_id;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + location_id +
                ", location_name='" + location_name + '\'' +
                ", location_city='" + location_city + '\'' +
                '}';
    }
}
