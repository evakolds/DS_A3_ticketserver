package api;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ITicketService;
import services.models.Ticket;
import gallery.ticketserver.TicketServerApplication;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@RequiredArgsConstructor
public final class TicketController {
    static final Logger log = LoggerFactory.getLogger(TicketServerApplication.class);

    @Autowired
    private ITicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Ticket>> index() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody TicketPayload payload) {
        Ticket newTicket = new Ticket(payload.getPrice());
        return ResponseEntity.ok(ticketService.save(newTicket));
    }


    @GetMapping("{ticketId}")
    public ResponseEntity<Ticket> show(@PathVariable String ticketId) throws NotFoundException {
        return ResponseEntity.ok(ticketService.getById(ticketId));
    }

    @DeleteMapping("{ticketId}")
    public ResponseEntity<Void> delete(@PathVariable String ticketId) throws NotFoundException {
        ticketService.deleteById(ticketId);
        return ResponseEntity.noContent().build();
    }
}