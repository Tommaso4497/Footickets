package Footicket.tickets;



import Footicket.users.User;
import Footicket.matches.Match;
import java.io.Serializable;

public class Ticket implements Serializable
{
    private Match match;
    private User user;
    private String IDTicket;
    
    @Override
    public String toString() {
        return "Biglietto = " + this.getIDTicket() + ", ID Volo = " + this.match.getID() + ", Squadra di casa= " + this.match.getHomeTeam() + ", Squadra ospite = " + this.match.getGuestTeam() + ", Data incontro= " + this.match.getDate() + ", Stadio = " + this.match.getPlace() + ", Prezzo = " + this.match.getPrice() + ", Nome = " + this.user.getName() + ", Cognome = " + this.user.getSurname() + ", Data di Nascita = " + this.user.getBirth() + ", Codice Fiscale= " + this.user.getCode() + '}';
    }
    
    public Ticket( Match match,  User user) {
        this.match = match;
        this.user = user;
        this.IDTicket = this.generateID();
    }
    
    private String generateID() {
        if (Tickets.getInstance().isEmpty()) {
            return "1234567890";
        }
        int aux = Integer.valueOf(Tickets.getInstance().getTicket(Tickets.getInstance().size() - 1).getIDTicket());
        return String.valueOf(++aux);
    }
    
    public Match getMatch() {
        return this.match;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public String getIDTicket() {
        return this.IDTicket;
    }
}