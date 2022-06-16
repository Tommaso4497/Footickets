package Footicket;

import Footicket.tickets.Tickets;
import Footicket.matches.Match;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestTicket {
    @Test
    void checkTicketListNull() {
        assertNotEquals(null, Tickets.getInstance().getTicketList());
    }

    @Test
    void checkFlightID() {
        Match match = new Match("INTER", "MILAN", "14/10/2021",
                "SAN SIRO", "\u20ac30.00", "54PO69", "50");

        assertEquals("54PO69", match.getID());
    }

}
