package Footicket.GUI;


import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import Footicket.tickets.Ticket;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeeTicket extends JPanel
{
    private JLabel IDMatch;
    private JLabel homeTeam;
    private JLabel guestTeam;
    private JLabel price;
    private JLabel place;
    private JLabel seating;
    private JLabel name;
    private JLabel surname;
    private JLabel birth;
    private JLabel code;
    private JLabel IDTicket;
    private JButton goBack;
    private ArrayList<Ticket> tickets;
    int i;
    private static final int WIDTH_FRAME = 1000;
    private static final int HEIGHT_FRAME = 600;
    
    public SeeTicket( ArrayList<Ticket> tickets,  int i) {
        this.setSize(1000, 600);
        this.setLayout(new GridLayout(12, 2));
        this.tickets = tickets;
        this.i = i;
        (this.IDMatch = new JLabel()).setText("ID Match: " + tickets.get(i).getMatch().getID());
        this.add(this.IDMatch);
        (this.homeTeam = new JLabel()).setText("Squadra di casa: " + tickets.get(i).getMatch().getHomeTeam());
        this.add(this.homeTeam);
        (this.guestTeam = new JLabel()).setText("Squadra ospite: " + tickets.get(i).getMatch().getGuestTeam());
        this.add(this.guestTeam);
        (this.place = new JLabel()).setText("Stadio: " + tickets.get(i).getMatch().getPlace());
        this.add(this.place);
        (this.name = new JLabel()).setText("Nome: " + tickets.get(i).getUser().getName());
        this.add(this.name);
        (this.surname = new JLabel()).setText("Cognome: " + tickets.get(i).getUser().getSurname());
        this.add(this.surname);
        (this.birth = new JLabel()).setText("Data di nascita: " + tickets.get(i).getUser().getBirth());
        this.add(this.birth);
        (this.code = new JLabel()).setText("Codice Fiscale" + tickets.get(i).getUser().getCode());
        this.add(this.code);
        (this.IDTicket = new JLabel()).setText("ID biglietto: " + tickets.get(i).getIDTicket());
        this.add(this.IDTicket);
        (this.price = new JLabel()).setText("Prezzo: " + tickets.get(i).getMatch().getPrice());
        this.add(this.price);
        (this.seating = new JLabel()).setText("Posto: " + tickets.get(i).getMatch().getSeating());
        this.add(this.seating);
        (this.goBack = new JButton("Indietro")).addActionListener(ActionEvent -> this.goToStart());
        this.add(this.goBack);
    }
    
    private void goToStart() {
        this.removeAll();
        this.setLayout(new FlowLayout());
        BuyPanel start = new BuyPanel();
        this.setVisible(false);
        this.add(start);
        this.setVisible(true);
    }
}