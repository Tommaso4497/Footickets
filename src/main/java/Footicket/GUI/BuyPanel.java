package Footicket.GUI;


import java.awt.event.ActionEvent;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BuyPanel extends JPanel {
/*ciao*/
    private static final int WIDTH_FRAME = 1000;
    private static final int HEIGHT_FRAME = 600;
    private JButton buyButton;
    private JButton searchTicketsButton;

    public BuyPanel() {
        this.setSize(WIDTH_FRAME, HEIGHT_FRAME);
        this.buyButton = new JButton();
        this.searchTicketsButton = new JButton();
        this.buyButton.setText("Compra");
        this.add(this.buyButton);
        this.searchTicketsButton.setText("Visualizza biglietti acquistati");
        this.add(this.searchTicketsButton);
        this.buyButton.addActionListener(ActionEvent -> this.goToPurchase());
        this.searchTicketsButton.addActionListener(ActionEvent -> this.goToSearchTickets());
        this.setVisible(true);
    }

    private void goToPurchase() {
        this.removeAll();
        this.setLayout(new FlowLayout());
         Purchase purchase = new Purchase();
        this.setVisible(false);
        this.add(purchase);
        this.setVisible(true);
    }

    private void goToSearchTickets() {
        this.removeAll();
        this.setLayout(new FlowLayout());
         SearchTicket searchTicket = new SearchTicket();
        this.setVisible(false);
        this.add(searchTicket);
        this.setVisible(true);
    }
}
