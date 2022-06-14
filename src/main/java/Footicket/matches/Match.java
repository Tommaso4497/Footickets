package Footicket.matches;


import java.io.Serializable;

public class Match implements Serializable
{
    private String homeTeam;
    private String guestTeam;
    private String date;
    private String place;
    private String price;
    private String ID;
    private int seating;
    
    public Match( String homeTeam,  String guestTeam,  String date,  String place,  String price,  String ID,  int seating) {
        this.ID = ID;
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.date = date;
        this.place = place;
        this.price = price;
        this.seating = seating;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.homeTeam) + " | " + this.guestTeam + " | " + this.date + " | " + this.place + " | " + this.price + " | " + this.ID;
    }
    
    public String getID() {
        return this.ID;
    }
    
    public String getHomeTeam() {
        return this.homeTeam;
    }
    
    public String getGuestTeam() {
        return this.guestTeam;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getPlace() {
        return this.place;
    }
    
    public String getPrice() {
        return this.price;
    }
    
    public int getSeating() {
        return this.seating;
    }
}