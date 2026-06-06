package ch.werkstattteam.werkstattpilot.business;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: AuftragFactory.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Einfache Factory zum Erstellen von Auftrag-Objekten.
 */

/**
 * Erstellt Auftrag-Objekte an einer zentralen Stelle.
 */
public class AuftragFactory {

    /**
     * Erstellt eine neue AuftragFactory.
     */
    public AuftragFactory() {
    }

    /**
     * Erstellt einen neuen Auftrag mit dem Startstatus OFFEN.
     *
     * @param auftragsNummer eindeutige Nummer des Auftrags
     * @return neuer Auftrag
     */
    public Auftrag erstelleAuftrag(int auftragsNummer) {
        return new Auftrag(auftragsNummer, Auftragsstatus.OFFEN);
    }
}
