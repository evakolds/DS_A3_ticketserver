package services;

import javassist.NotFoundException;
import services.models.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAll();

    Ticket save(Ticket ticketForSave);

    Ticket getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}

