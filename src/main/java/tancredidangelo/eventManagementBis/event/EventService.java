package tancredidangelo.eventManagementBis.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tancredidangelo.eventManagementBis.event.eventDTO.NewEventDTO;
import tancredidangelo.eventManagementBis.event.eventDTO.UpdateEventDTO;
import tancredidangelo.eventManagementBis.exceptionHandling.exceptions.NotFoundException;

import java.util.List;

@Service
@Slf4j
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    /// methods

    public Event save(NewEventDTO payload) {

        // TODO: check for permissions

        Event newEvent = new Event(payload.title(), payload.description(), payload.date(), payload.place(), payload.capacity(), payload.creator());
        return this.eventRepository.save(newEvent);
    }

    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }

    public Event findById(Long id) {
        return this.eventRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Event not found."));
    }

    public Event updateById(Long id, UpdateEventDTO payload) {

        // TODO: check for permissions

        Event found = findById(id);

        found.setTitle(payload.title());
        found.setDescription(payload.description());
        found.setDate(payload.date());
        found.setPlace(payload.place());
        found.setCapacity(payload.capacity());

        return this.eventRepository.save(found);
    }


    public void deleteById(Long id) {

        // TODO: check for permissions

        Event found = findById(id);

        this.eventRepository.deleteById(id);
    }


    public void deleteAll() {

        // TODO: check for permissions

        this.eventRepository.deleteAll();
    }


}
