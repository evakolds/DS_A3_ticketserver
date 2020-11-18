package services;

import services.models.Ticket;
import services.repository.TicketRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private TicketRepository repository;

    @Override
    public List<Ticket> findAll() {
        return (List<Ticket>) repository.findAll();
    }

    @Override
    public Ticket save(Ticket ticketForSave) {
        return repository.save(ticketForSave);
    }

    @Override
    public Ticket getById(String id) throws NotFoundException {
        Optional<Ticket> tempTicket = repository.findById(id);
        if (tempTicket.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Ticket with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}