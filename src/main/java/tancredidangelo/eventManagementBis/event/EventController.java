package tancredidangelo.eventManagementBis.event;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tancredidangelo.eventManagementBis.event.eventDTO.NewEventDTO;
import tancredidangelo.eventManagementBis.event.eventDTO.UpdateEventDTO;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    /// dependency injection EventService
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    /// ----------------------- requests ----------------------------------------------------------------


    /// GET ALL EVENTS
    /// GET ".../events" -> 200 OK
    @GetMapping
    public List<Event> getEvents() {
        return this.eventService.findAll();
    }


    /// SAVE EVENT
    /// POST ".../events" -> 201 CREATED
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event saveEvent(@RequestBody NewEventDTO payload) {
        return this.eventService.save(payload);
    }


    /// GET EVENT BY ID
    /// GET ".../events/{eventId}" -> 200 OK
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return this.eventService.findById(id);
    }


    /// UPDATE EVENT
    /// PUT ".../events/{eventId}" -> 200 OK
    @PutMapping("/{id}")
    public Event updateEventById(@PathVariable Long id, @RequestBody UpdateEventDTO payload) {
        return this.eventService.updateById(id, payload);
    }

    /// DELETE EVENT
    /// DELETE ".../events/{eventId}" -> 200 OK
    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable Long id) {
        this.eventService.deleteById(id);
    }


    /// DELETE ALL EVENTS
    /// DELETE ".../events" -> 200 OK
    @DeleteMapping
    public void deleteAllEvents() {
        this.eventService.deleteAll();
    }
}