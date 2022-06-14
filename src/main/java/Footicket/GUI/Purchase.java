package Footicket.GUI;


import java.awt.FlowLayout;
import Footicket.matches.Match;
import Footicket.tickets.Tickets;
import Footicket.tickets.Ticket;
import Footicket.users.*;
import javax.swing.JOptionPane;
import Footicket.matches.Matches;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Purchase extends JPanel {

    private static final int WIDTH_FRAME = 1000;
    private static final int HEIGHT_FRAME = 600;
    private JButton back;
    private JButton buy;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel birthLabel;
    private JLabel codeLabel;
    private JLabel matchLabel;
    private JLabel priceLabel;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField birthField;
    private JTextField codeField;
    private JTextField priceField;
    private JComboBox match;

    public Purchase() {
        this.setSize(1000, 600);
        this.setLayout(new GridLayout(7, 2));
        this.nameField = new JTextField();
        this.surnameField = new JTextField();
        this.birthField = new JTextField();
        this.codeField = new JTextField();
        this.priceField = new JTextField();
        this.add(this.nameLabel = new JLabel("Nome"));
        this.add(this.nameField);
        this.add(this.surnameLabel = new JLabel("Cognome"));
        this.add(this.surnameField);
        this.add(this.birthLabel = new JLabel("Data di Nascita"));
        this.add(this.birthField);
        this.add(this.codeLabel = new JLabel("Codice Fiscale"));
        this.add(this.codeField);
        this.add(this.matchLabel = new JLabel("Partite"));
        Matches.getInstance().createList();
        (this.match = new JComboBox(Matches.getInstance().showMatches())).setSelectedIndex(0);
        this.add(this.match);
        this.add(this.priceLabel = new JLabel("Prezzo"));
        this.priceField.setText("--");
        this.priceField.setEditable(false);
        this.add(this.priceField);
        this.match.addActionListener(ActiveEvent -> this.priceField.setText(Matches.getInstance().getMatch(this.match.getSelectedIndex()).getPrice()));
        (this.back = new JButton()).setText("Back");
        this.add(this.back);
        this.back.addActionListener(ActionEvent -> this.goToStart());
        this.setVisible(true);
        (this.buy = new JButton()).setText("Compra");
        this.add(this.buy);

        this.buy.addActionListener(ActionEvent -> {
            if (this.nameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Devi inserire il nome!", "Errore", 0);
            } else if (this.surnameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Devi inserire il cognome!", "Errore", 0);
            } else if (this.birthField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Devi inserire la data di nascita!", "Errore", 0);
            } else if (this.codeLabel.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Devi inserire il Codice Fiscale!", "Errore", 0);
            } else if (this.match.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Devi scegliere un match!", "Errore", 0);
            } else {
                Match match = Matches.getInstance().getMatch(this.match.getSelectedIndex());
                String name = this.nameField.getText();
                String surname = this.surnameField.getText();
                String bornDate = this.birthField.getText();
                String code = this.codeField.getText();
                User user = new User(name, surname, bornDate, code);
                Ticket ticketUser = new Ticket(match, user);
                try {
                    Tickets.getInstance().addTicket(ticketUser);
                    try {
                        JOptionPane.showMessageDialog(this, "Biglietto acquistato!");
                        this.goToStart();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Non \u00e8 possibile salvare: " + e.getMessage(), "Errore", 0);
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(this, "Non \u00e8 possibile acquistare!", "Errore", 0);
                    this.refreshPanel();
                }
            }
            return;
        });
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

    private void refreshPanel() {
        this.removeAll();
        this.setLayout(new FlowLayout());
        Purchase purchase = new Purchase();
        this.setVisible(false);
        this.add(purchase);
        this.setVisible(true);
    }
}
