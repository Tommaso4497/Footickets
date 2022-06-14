package Footicket.GUI;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
    public static BuyPanel buyPanel;
    private static final int WIDTH_FRAME = 1000;
    private static final int HEIGHT_FRAME = 600;
    
    public MainFrame() {
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("COMPRA TICKET");
        MainFrame.buyPanel = new BuyPanel();
        this.getContentPane().add(MainFrame.buyPanel);
        MainFrame.buyPanel.setVisible(true);
    }
}