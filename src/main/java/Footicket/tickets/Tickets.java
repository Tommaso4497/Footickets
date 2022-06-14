package Footicket.tickets;


import Footicket.matches.Match;
import Footicket.users.User;
import java.util.ArrayList;
import java.io.Serializable;

public class Tickets implements Serializable
{
    private ArrayList<Ticket> tickets;
    private static Tickets instance;
    
    static {
        Tickets.instance = new Tickets();
    }
    
    public static Tickets getInstance() {
        return Tickets.instance;
    }
    
    private Tickets() {
        this.tickets = new ArrayList<Ticket>();
    }
    
    public void addTicket(Ticket ticket) throws Exception {
        if (getInstance().buySameTicket(ticket.getUser(), ticket.getMatch()) || getInstance().checkSameCode(ticket.getUser())) {
            throw new Exception();
        }
        this.tickets.add(ticket);
    }
    
    public int size() {
        return this.tickets.size();
    }
    
    public Ticket getTicket( int i) {
        return this.tickets.get(i);
    }
    
    public ArrayList<Ticket> getTicketList() {
        return this.tickets;
    }
    
    public void setTicketList( ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    public boolean isEmpty() {
        return this.tickets.isEmpty();
    }
    
    public boolean buySameTicket( User user,  Match match) {
        int flag = 0;
        for (int i = 0; i < getInstance().size(); ++i) {
            if (user.getCode().equalsIgnoreCase(getInstance().tickets.get(i).getUser().getCode()) && match.getID().equalsIgnoreCase(getInstance().tickets.get(i).getMatch().getID())) {
                ++flag;
            }
        }
        return flag > 0;
    }
    
    public boolean checkSameCode( User user) {
        int go = 0;
        for (int i = 0; i < getInstance().size(); ++i) {
             boolean b1 = user.getCode().equalsIgnoreCase(getInstance().tickets.get(i).getUser().getCode());
            if (user.getCode().equalsIgnoreCase(getInstance().tickets.get(i).getUser().getCode())) {
                if (b1) {
                    ++go;
                    break;
                }
                go = -1;
            }
        }
        return go == -1;
    }
    
    public ArrayList<Ticket> getFilteredTickets( String code) {
         ArrayList<Ticket> aux = new ArrayList<Ticket>();
        for (int i = 0; i < this.tickets.size(); ++i) {
            if (this.tickets.get(i).getUser().getCode().equals(code)) {
                aux.add(this.tickets.get(i));
            }
        }
        return aux;
    }
}