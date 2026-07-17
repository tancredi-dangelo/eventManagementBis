package tancredidangelo.eventManagementBis.eventCreator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tancredidangelo.eventManagementBis.eventCreator.eventCreatorDTO.NewEventCreatorDTO;
import tancredidangelo.eventManagementBis.eventCreator.eventCreatorDTO.UpdateEventCreatorDTO;
import tancredidangelo.eventManagementBis.exceptionHandling.exceptions.NotFoundException;

import java.util.List;

@Service
@Slf4j
public class EventCreatorService {

    private final EventCreatorRepository eventCreatorRepository;


    public EventCreatorService(EventCreatorRepository eventCreatorRepository) {
        this.eventCreatorRepository = eventCreatorRepository;
    }


    /// methods

    public EventCreator save(NewEventCreatorDTO payload) {
        EventCreator newEventCreator = new EventCreator(payload.name(), payload.surname(), payload.email(), payload.password());
        return this.eventCreatorRepository.save(newEventCreator);
    }

    public List<EventCreator> findAll() {
        return this.eventCreatorRepository.findAll();
    }

    public EventCreator findById(Long id) {
        return this.eventCreatorRepository.findById(id).orElseThrow(() -> new NotFoundException("Event Creator not found."));
    }

    public EventCreator updateById(Long id, UpdateEventCreatorDTO payload) {

        // TODO: check for permissions

        EventCreator found = findById(id);

        found.setName(payload.name());
        found.setSurname(payload.surname());
        found.setEmail(payload.email());
        found.setPassword(payload.password());

        return this.eventCreatorRepository.save(found);
    }

    public void deleteById(Long id) {

        // TODO: check for permissions

        EventCreator found = findById(id);
        this.eventCreatorRepository.deleteById(id);
    }

    public void deleteAll() {

        // TODO: check for permissions

        this.eventCreatorRepository.deleteAll();
    }


    public EventCreator findByEmail(String email) {
        return this.eventCreatorRepository.findByEmail(email);
    }

}
