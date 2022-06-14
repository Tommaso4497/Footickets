package Footicket.GUI;


import java.awt.FlowLayout;
import Footicket.tickets.Ticket;
import java.util.ArrayList;
import Footicket.tickets.Tickets;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class SearchTicket extends JPanel {

    private static final int WIDTH_FRAME = 1000;
    private static final int HEIGHT_FRAME = 600;
    private JTextField codeField;
    private JLabel codeLabel;
    private JButton back;
    private JButton search;

    public SearchTicket() {
        this.setSize(1000, 600);
        this.setLayout(new GridLayout(2, 2));
        this.back = new JButton();
        this.search = new JButton();
        this.codeField = new JTextField();
        this.add(this.codeLabel = new JLabel("Codice Fiscale"));
        this.add(this.codeField);
        this.back.setText("Indietro");
        this.add(this.back);
        this.back.addActionListener(ActionEvent -> this.goToStart());
        this.search.setText("Cerca");
        this.add(this.search);

        this.search.addActionListener(ActionEvent -> {
            if (this.codeField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Inserire codice fiscale", "Errore", 0);
            } else {
                String code = this.codeField.getText();
                ArrayList<Ticket> filteredTickets = Tickets.getInstance().getFilteredTickets(code);
                if (filteredTickets.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Non ci sono biglietti!");
                } else {
                    this.goToShowTickets(filteredTickets);
                }
            }
            return;
        });
        this.setVisible(true);
    }

    private void goToShowTickets(ArrayList<Ticket> filteredTickets) {
        this.removeAll();
        this.setLayout(new FlowLayout());
        ShowBuyTicket show = new ShowBuyTicket((ArrayList) filteredTickets);
        this.setVisible(false);
        this.add((Component) show);
        this.setVisible(true);
    }

    private void goToStart() {
        this.removeAll();
        this.setLayout(new FlowLayout());
        BuyPanel buyPanel = new BuyPanel();
        this.setVisible(false);
        this.add(buyPanel);
        this.setVisible(true);
    }
}
