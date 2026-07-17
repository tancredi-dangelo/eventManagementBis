package tancredidangelo.eventManagementBis.eventCreator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCreatorRepository extends JpaRepository<EventCreator, Long> {

}
