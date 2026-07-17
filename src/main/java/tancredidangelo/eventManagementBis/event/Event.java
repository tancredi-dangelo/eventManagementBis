package tancredidangelo.eventManagementBis.event;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tancredidangelo.eventManagementBis.eventCreator.EventCreator;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Event {

    /// attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private LocalDate date;

    @Column
    private String place;

    @Column
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "creator")
    @Setter(AccessLevel.NONE)
    private EventCreator creator;


    /// constructor
    public Event(String title, String description, LocalDate date, String place, int capacity, EventCreator creator) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.place = place;
        this.capacity = capacity;
        this.creator = creator;
    }


    /// to string
    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", place='" + place + '\'' +
                ", capacity=" + capacity +
                ", creator=" + creator +
                '}';
    }
}
