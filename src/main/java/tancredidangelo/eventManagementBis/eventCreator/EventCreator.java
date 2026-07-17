package tancredidangelo.eventManagementBis.eventCreator;

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
public class EventCreator extends User {

    /// attribute

    @OneToMany(mappedBy = "creator")
    private List<Event> events_created;

    /// constructor

    public EventCreator(String name, String surname, String email, String password) {
        super(name, surname, email, password);
        this.setEventCreator(true);
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
