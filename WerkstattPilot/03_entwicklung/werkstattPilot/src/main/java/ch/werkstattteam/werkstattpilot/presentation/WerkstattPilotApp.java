package ch.werkstattteam.werkstattpilot.presentation;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: WerkstattPilotApp.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Startklasse der Anwendung.
 */

/**
 * Startet den WerkstattPilot-Prototyp.
 */
public class WerkstattPilotApp {

    /**
     * Erstellt eine neue Startklasse.
     */
    public WerkstattPilotApp() {
    }

    /**
     * Startpunkt des Programms.
     *
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        ConsoleClient client = new ConsoleClient();
        client.starten();
    }
}
