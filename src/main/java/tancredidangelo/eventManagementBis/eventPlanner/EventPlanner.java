package tancredidangelo.eventManagementBis.eventPlanner;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tancredidangelo.eventManagementBis.event.Event;
import tancredidangelo.eventManagementBis.user.User;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class EventPlanner extends User {

    /// attribute

    @OneToMany(mappedBy = "creator")
    private List<Event> events_created;

    /// constructor

    public EventPlanner(String name, String surname, String email, String password, List<Event> events_created) {
        super(name, surname, email, password);
        this.events_created = events_created;
    }


    /// to string
    @Override
    public String toString() {
        return "EventPlanner{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", surname='" + this.getSurname() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                "events_created=" + events_created +
                '}';
    }
}
