package tancredidangelo.eventManagementBis.eventCreator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tancredidangelo.eventManagementBis.eventCreator.eventCreatorDTO.NewEventCreatorDTO;
import tancredidangelo.eventManagementBis.eventCreator.eventCreatorDTO.UpdateEventCreatorDTO;

import java.util.List;

@RestController
@RequestMapping("/creators")
public class EventCreatorController {
    /// dependency injection EventCreatorService
    private final EventCreatorService eventCreatorService;

    public EventCreatorController(EventCreatorService eventCreatorService) {
        this.eventCreatorService = eventCreatorService;
    }

    /// ----------------------- requests ----------------------------------------------------------------


    /// GET ALL EVENT CREATORS
    /// GET ".../event-creators" -> 200 OK
    @GetMapping
    public List<EventCreator> getEventCreators() {
        return this.eventCreatorService.findAll();
    }


    /// SAVE EVENT CREATOR
    /// POST ".../event-creators" -> 201 CREATED
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventCreator saveEventCreator(@RequestBody NewEventCreatorDTO payload) {
        return this.eventCreatorService.save(payload);
    }


    /// GET EVENT CREATOR BY ID
    /// GET ".../event-creators/{id}" -> 200 OK
    @GetMapping("/{id}")
    public EventCreator getEventCreatorById(@PathVariable Long id) {
        return this.eventCreatorService.findById(id);
    }


    /// UPDATE EVENT CREATOR
    /// PUT ".../event-creators/{id}" -> 200 OK
    @PutMapping("/{id}")
    public EventCreator updateEventCreatorById(@PathVariable Long id, @RequestBody UpdateEventCreatorDTO payload) {
        return this.eventCreatorService.updateById(id, payload);
    }

    /// DELETE EVENT CREATOR
    /// DELETE ".../event-creators/{id}" -> 200 OK
    @DeleteMapping("/{id}")
    public void deleteEventCreatorById(@PathVariable Long id) {
        this.eventCreatorService.deleteById(id);
    }


    /// DELETE ALL EVENT CREATORS
    /// DELETE ".../event-creators" -> 200 OK
    @DeleteMapping
    public void deleteAllEventCreators() {
        this.eventCreatorService.deleteAll();
    }




}
