package Footicket.matches;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.io.Serializable;

public class Matches implements Serializable
{
    private List<Match> matches;
    private Match match;
    private static Matches instance;
    Random rd;
    
    static {
        Matches.instance = new Matches();
    }
    
    public static Matches getInstance() {
        return Matches.instance;
    }
    
    private Matches() {
        this.matches = new ArrayList<Match>(6);
        this.rd = new Random();
    }
    
    public void createList() {
        this.matches.add(this.match = new Match("", "", "", "", "", "", 0));
        this.matches.add(this.match = new Match("INTER", "SAMPDORIA", "25/02/22", "SAN SIRO", "\u20ac30.00", "60AS21", this.rd.nextInt(30000)));
        this.matches.add(this.match = new Match("LAZIO", "CAGLIARI", "12/09/22", "OLIMPICO", "\u20ac15.00", "99JU256", this.rd.nextInt(30000)));
        this.matches.add(this.match = new Match("NAPOLI", "GENOA", "25/04/22", "MARADONA", "\u20ac20.00", "23LO25", this.rd.nextInt(30000)));
        this.matches.add(this.match = new Match("INTER", "NAPOLI", "13/10/22", "SAN SIRO", "\u20ac60.00", "03BA89", this.rd.nextInt(30000)));
        this.matches.add(this.match = new Match("MILAN", "ROMA", "25/03/22", "SAN SIRO", "\u20ac60.00", "64PX01", this.rd.nextInt(30000)));
    }
    
    public String[] showMatches() {
         String[] MatchesList = new String[6];
        for (int i = 0; i < 6; ++i) {
            MatchesList[i] = this.matches.get(i).toString();
        }
        return MatchesList;
    }
    
    public Match getMatch( int i) {
        return this.matches.get(i);
    }
}