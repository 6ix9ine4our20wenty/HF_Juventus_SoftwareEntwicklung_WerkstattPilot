package ch.werkstattteam.werkstattpilot.business;

import java.util.List;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: AuftragService.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Schnittstelle der Business-Schicht für Aufträge.
 */

/**
 * Definiert die fachlichen Operationen für Aufträge.
 */
public interface AuftragService {

    /**
     * Legt einen neuen Auftrag an und speichert ihn.
     *
     * @param auftragsNummer eindeutige Nummer des Auftrags
     * @return neu angelegter Auftrag
     */
    Auftrag auftragAnlegen(int auftragsNummer);

    /**
     * Ändert den Status eines bestehenden Auftrags.
     *
     * @param auftragsNummer Nummer des bestehenden Auftrags
     * @param neuerStatus neuer Status des Auftrags
     * @return aktualisierter Auftrag
     */
    Auftrag statusAendern(int auftragsNummer, Auftragsstatus neuerStatus);

    /**
     * Liest einen einzelnen Auftrag.
     *
     * @param auftragsNummer Nummer des gesuchten Auftrags
     * @return gefundener Auftrag
     */
    Auftrag auftragLesen(int auftragsNummer);

    /**
     * Liest alle gespeicherten Aufträge.
     *
     * @return Liste aller Aufträge
     */
    List<Auftrag> alleAuftraegeLesen();
}
