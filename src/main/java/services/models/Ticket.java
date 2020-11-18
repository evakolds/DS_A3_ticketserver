package services.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "tickets")

public final class Ticket {
    @Id
    private String ticket_id;
    private int price;

    public Ticket(int price){
        this.price = price;
        this.ticket_id = UUID.randomUUID().toString();
    }

    public Ticket() {

    }

    public String getTicket_id() {
        return ticket_id;
    }

    public int getPrice() {
        return price;
    }
}