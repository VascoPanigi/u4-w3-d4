package VascoPanigi.entities;

import VascoPanigi.enums.EventType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Football_match")
public class Football_match extends Event{
    private String home_team;
    private String visiting_team;
    private String winning_team;
    private int home_team_goals;
    private int visiting_team_goals;

    public Football_match(){}

    public Football_match(String title, LocalDate event_date, String description, EventType event_type, int max_participants, Location location, int visiting_team_goals, int home_team_goals, String winning_team, String visiting_team, String home_team) {
        super(title, event_date, description, event_type, max_participants, location);
        this.visiting_team_goals = visiting_team_goals;
        this.home_team_goals = home_team_goals;
        this.winning_team = winning_team;
        this.visiting_team = visiting_team;
        this.home_team = home_team;
    }

    public int getVisiting_team_goals() {
        return visiting_team_goals;
    }

    public void setVisiting_team_goals(int visiting_team_goals) {
        this.visiting_team_goals = visiting_team_goals;
    }

    public int getHome_team_goals() {
        return home_team_goals;
    }

    public void setHome_team_goals(int home_team_goals) {
        this.home_team_goals = home_team_goals;
    }

    public String getWinning_team() {
        return winning_team;
    }

    public void setWinning_team(String winning_team) {
        this.winning_team = winning_team;
    }

    public String getVisiting_team() {
        return visiting_team;
    }

    public void setVisiting_team(String visiting_team) {
        this.visiting_team = visiting_team;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    @Override
    public String toString() {
        return "Football_match{" +
                "home_team='" + home_team + '\'' +
                ", visiting_team='" + visiting_team + '\'' +
                ", winning_team='" + winning_team + '\'' +
                ", home_team_goals=" + home_team_goals +
                ", visiting_team_goals=" + visiting_team_goals +
                ", event_id=" + event_id +
                ", title='" + title + '\'' +
                ", location=" + location +
                ", max_participants=" + max_participants +
                ", event_type=" + event_type +
                ", description='" + description + '\'' +
                ", event_date=" + event_date +
                '}';
    }
}
