package ch.werkstattteam.werkstattpilot.business;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: Auftrag.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Fachliche Klasse Auftrag mit genau zwei Attributen.
 */

/**
 * Repraesentiert einen Werkstattauftrag im Prototyp.
 *
 * In Aufgabe 5 werden bewusst nur zwei Attribute umgesetzt:
 * auftragsNummer und status.
 */
public class Auftrag {

    private int auftragsNummer;
    private Auftragsstatus status;

    /**
     * Erstellt einen Auftrag mit Auftragsnummer und Status.
     *
     * @param auftragsNummer eindeutige Nummer des Auftrags
     * @param status aktueller Status des Auftrags
     */
    public Auftrag(int auftragsNummer, Auftragsstatus status) {
        setAuftragsNummer(auftragsNummer);
        setStatus(status);
    }

    /**
     * Gibt die Auftragsnummer zurueck.
     *
     * @return Auftragsnummer des Auftrags
     */
    public int getAuftragsNummer() {
        return auftragsNummer;
    }

    /**
     * Setzt die Auftragsnummer.
     *
     * @param auftragsNummer eindeutige Nummer des Auftrags
     */
    public void setAuftragsNummer(int auftragsNummer) {
        if (auftragsNummer <= 0) {
            throw new IllegalArgumentException("Auftragsnummer muss groesser als 0 sein.");
        }

        this.auftragsNummer = auftragsNummer;
    }

    /**
     * Gibt den aktuellen Status zurueck.
     *
     * @return aktueller Auftragsstatus
     */
    public Auftragsstatus getStatus() {
        return status;
    }

    /**
     * Setzt den aktuellen Status.
     *
     * @param status neuer Status des Auftrags
     */
    public void setStatus(Auftragsstatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status darf nicht leer sein.");
        }

        this.status = status;
    }

    /**
     * Gibt den Auftrag als einfachen Text zurueck.
     *
     * @return Textdarstellung fuer die Konsole
     */
    @Override
    public String toString() {
        return "Auftrag " + auftragsNummer + " - Status: " + status;
    }
}
