package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketManagerTest {

    @Test
    public void shouldSortTickets() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("AER", "MRV", 300, 15, 16);
        Ticket ticket2 = new Ticket("DMV", "MSQ", 250, 11, 13);
        Ticket ticket3 = new Ticket("MSQ", "AER", 450, 5, 9);
        Ticket ticket4 = new Ticket("LED", "MSQ", 200, 17, 20);
        Ticket ticket5 = new Ticket("DMV", "MSQ", 200, 9, 10);
        Ticket ticket6 = new Ticket("DMV", "MSQ", 250, 13, 14);
        Ticket ticket7 = new Ticket("DMV", "MSQ", 100, 19, 20);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("DMV", "MSQ");
        Ticket[] expected = {ticket7, ticket5, ticket2, ticket6};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortOneTicket() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("AER", "MRV", 300, 15, 16);
        Ticket ticket2 = new Ticket("DMV", "MSQ", 150, 11, 13);
        Ticket ticket3 = new Ticket("MSQ", "AER", 450, 5, 9);
        Ticket ticket4 = new Ticket("LED", "MSQ", 200, 17, 20);
        Ticket ticket5 = new Ticket("DMV", "MSQ", 200, 9, 10);
        Ticket ticket6 = new Ticket("DMV", "MSQ", 250, 13, 14);
        Ticket ticket7 = new Ticket("DMV", "MSQ", 100, 19, 20);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("LED", "MSQ");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortZeroTickets() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("AER", "MRV", 300, 15, 16);
        Ticket ticket2 = new Ticket("DMV", "MSQ", 150, 11, 13);
        Ticket ticket3 = new Ticket("MSQ", "AER", 450, 5, 9);
        Ticket ticket4 = new Ticket("LED", "MSQ", 200, 17, 20);
        Ticket ticket5 = new Ticket("DMV", "MSQ", 200, 9, 10);
        Ticket ticket6 = new Ticket("DMV", "MSQ", 250, 13, 14);
        Ticket ticket7 = new Ticket("DMV", "MSQ", 100, 19, 20);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("MSQ", "DMV");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortTicketsWhitComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("AER", "MRV", 300, 15, 16);
        Ticket ticket2 = new Ticket("DMV", "MSQ", 150, 11, 13);
        Ticket ticket3 = new Ticket("MSQ", "AER", 450, 5, 9);
        Ticket ticket4 = new Ticket("LED", "MSQ", 200, 17, 20);
        Ticket ticket5 = new Ticket("DMV", "MSQ", 200, 9, 10);
        Ticket ticket6 = new Ticket("DMV", "MSQ", 250, 13, 20);
        Ticket ticket7 = new Ticket("DMV", "MSQ", 100, 19, 21);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("DMV", "MSQ", comparator);
        Ticket[] expected = {ticket5, ticket2, ticket7, ticket6};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortOneTicketWhitComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("AER", "MRV", 300, 15, 16);
        Ticket ticket2 = new Ticket("DMV", "MSQ", 150, 11, 13);
        Ticket ticket3 = new Ticket("MSQ", "AER", 450, 5, 9);
        Ticket ticket4 = new Ticket("LED", "MSQ", 200, 17, 20);
        Ticket ticket5 = new Ticket("DMV", "MSQ", 200, 9, 10);
        Ticket ticket6 = new Ticket("DMV", "MSQ", 250, 13, 20);
        Ticket ticket7 = new Ticket("DMV", "MSQ", 100, 19, 21);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSQ", "AER", comparator);
        Ticket[] expected = {ticket3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortZeroTicketsWhitComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("AER", "MRV", 300, 15, 16);
        Ticket ticket2 = new Ticket("DMV", "MSQ", 150, 11, 13);
        Ticket ticket3 = new Ticket("MSQ", "AER", 450, 5, 9);
        Ticket ticket4 = new Ticket("LED", "MSQ", 200, 17, 20);
        Ticket ticket5 = new Ticket("DMV", "MSQ", 200, 9, 10);
        Ticket ticket6 = new Ticket("DMV", "MSQ", 250, 13, 20);
        Ticket ticket7 = new Ticket("DMV", "MSQ", 100, 19, 21);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("DMV", "MRV", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }
}
