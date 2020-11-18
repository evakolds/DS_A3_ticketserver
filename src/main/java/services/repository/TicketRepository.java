package services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import services.models.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, String> {

}