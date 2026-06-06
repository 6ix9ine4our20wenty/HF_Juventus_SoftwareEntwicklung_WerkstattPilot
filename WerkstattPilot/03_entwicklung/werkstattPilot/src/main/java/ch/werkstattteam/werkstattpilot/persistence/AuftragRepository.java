package ch.werkstattteam.werkstattpilot.persistence;

import java.util.List;

import ch.werkstattteam.werkstattpilot.business.Auftrag;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: AuftragRepository.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Schnittstelle der Persistence-Schicht für Aufträge.
 */

/**
 * Definiert den Zugriff auf gespeicherte Auftrag-Objekte.
 */
public interface AuftragRepository {

    /**
     * Speichert einen Auftrag in der Mock-DB.
     *
     * @param auftrag zu speichernder Auftrag
     */
    void speichern(Auftrag auftrag);

    /**
     * Liest einen Auftrag anhand der Auftragsnummer.
     *
     * @param auftragsNummer Nummer des gesuchten Auftrags
     * @return gefundener Auftrag oder null
     */
    Auftrag lesen(int auftragsNummer);

    /**
     * Liest alle Aufträge aus der Mock-DB.
     *
     * @return Liste aller Aufträge
     */
    List<Auftrag> alleLesen();

    /**
     * Aktualisiert einen bestehenden Auftrag.
     *
     * @param auftrag Auftrag mit aktualisierten Werten
     */
    void aktualisieren(Auftrag auftrag);
}
