package Footicket.GUI;



import Footicket.tickets.Tickets;

import java.awt.FlowLayout;

import java.awt.GridLayout;
import Footicket.tickets.Ticket;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ShowBuyTicket extends JPanel
{
    private JButton[] ticket;
    private JButton back;
    private static final int WIDTH_FRAME = 1000;
    private static final int HEIGHT_FRAME = 600;
    
    public ShowBuyTicket( ArrayList<Ticket> tickets) {
        this.ticket = new JButton[5];
        this.setSize(1000, 600);
        this.setLayout(new GridLayout(tickets.size() + 1, 1));
        for (int i = 0; i < tickets.size(); ++i) {
            (this.ticket[i] = new JButton()).setText("ID BIGLIETTO: " + tickets.get(i).getIDTicket());
            this.readTicket(this.ticket[i], i, tickets);
            this.add(this.ticket[i]);
        }
        (this.back = new JButton("Indietro")).addActionListener(ActionEvent -> this.goToSearchTickets());
        this.add(this.back);
        this.setVisible(true);
    }
    
    private void readTicket (JButton button,  int i,  ArrayList<Ticket> tickets) {
        button.addActionListener(ActionEvent -> this.goToSeeTicket(i, tickets));
    }
    
    private void goToSeeTicket( int i,  ArrayList<Ticket> tickets) {
        this.removeAll();
        this.setLayout(new FlowLayout());
         SeeTicket see = new SeeTicket(tickets, i);
        this.setVisible(false);
        this.add(see);
        this.setVisible(true);
    }
    
    private void goToSearchTickets() {
        this.removeAll();
        this.setLayout(new FlowLayout());
         SearchTicket search = new SearchTicket();
        this.setVisible(false);
        this.add(search);
        this.setVisible(true);
    }
}