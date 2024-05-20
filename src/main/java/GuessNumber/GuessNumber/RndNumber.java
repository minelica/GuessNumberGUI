package GuessNumber.GuessNumber;

import java.util.Random;

public class RndNumber {

    /** Initiale Message */
 //   private static final String MSG_START = "Neues Spiel - neues Glück!";
    /** Message Zahl erraten */
 //   private static final String MSG_ERRATEN = "Sie haben die Zahl erraten!";
    /** Message Zahl kleiner */
//    private static final String MSG_ZAHL_KLEINER = "Meine Zahl ist kleiner!";
    /** Message Zahl groesser */
 //   private static final String MSG_ZAHL_GROESSER = "Meine Zahl ist größer!";
    /** Message falsche Eingabe */
 //   private static final String MSG_FEHLEINGABE = "Bitte keinen Schrott eingeben!";

    /** Initiale Message */
    private static final String MSG_START = "New game - new luck!";
    /** Message Zahl erraten */
    private static final String MSG_ERRATEN = "You have guessed the number!";
    /** Message Zahl kleiner */
    private static final String MSG_ZAHL_KLEINER = "My number is smaller!";
    /** Message Zahl groesser */
    private static final String MSG_ZAHL_GROESSER = "My number is bigger!";
    /** Message falsche Eingabe */
    private static final String MSG_FEHLEINGABE = "Invalid input!";
    /** Zufallszahl */
    private int zufallszahl;
    /** Obergrenze fuer Zufallszahl */
    private int obergrenze;
    /** Flag ob die Zahl erraten wurde */
    private boolean erraten;
    /** Anzeigemeldung */
    private String message;
    /** Anzahl der Rateversuche */
    private int versuche;
    /** Tippeingabe */
    private String tippEingabe;

    /**
     * Default Konstruktor der als Obergrente 100 setzt.
     */
    public RndNumber() {
        this(100);
    }

    /**
     * Konstruktor, der Obergrenze per Parameter setzt.
     *
     * @param pObergrenze Obergrenze fuer Zufallszahlen.
     */
    public RndNumber(int pObergrenze) {
        obergrenze = pObergrenze;
        init();
    }

    /**
     * Liefert ein Flag ob die Zahl bereits erraten wurde.
     * 
     * @return true wenn die Zahl erraten wurde.
     */
    public boolean isErraten() {
        return erraten;
    }

    /**
     * Liefert die passende Meldung zum aktuellen Spielstatus.
     * 
     * @return Meldung.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Liefert die Anzahl der Rateversuche.
     *
     * @return Anzahl der Versuche.
     */
    public int getVersuche() {
        return versuche;
    }

    /**
     * TippEingabe setzen.
     */
    public void setTippEingabe(String tippEingabe) {
        this.tippEingabe = tippEingabe;
    }

    /**
     * Neue Zufallszahl erzeugen und alle sonstigen Werte auf Ausgangswerte setzen.
     */
    public void init() {
        Random myRandom = new Random();
        zufallszahl = myRandom.nextInt(obergrenze) + 1;
        versuche = 0;
        erraten = false;
        message = MSG_START;
        tippEingabe = "";
    }

    /**
     * Ratemethode - Auswertung des Rateversuchs und setzten des Modelstatus
     * (message, erraten, versuche).
     */
    public void auswertungTipp() {
        versuche++;
        int tipp = 0;
        try {
            tipp = Integer.parseInt(tippEingabe);
        } catch (NumberFormatException ex) {
            message = MSG_FEHLEINGABE;
            return;
        }
        if (tipp == zufallszahl) {
            erraten = true;
            message = MSG_ERRATEN;
        } else {
            if (tipp < zufallszahl) {
                message = MSG_ZAHL_GROESSER;
            } else {
                message = MSG_ZAHL_KLEINER;
            }
        }
    }
}
