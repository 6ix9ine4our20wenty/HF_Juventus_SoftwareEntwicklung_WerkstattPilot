package ch.werkstattteam.werkstattpilot.business;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: Auftragsstatus.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Enum mit den erlaubten Statuswerten eines Auftrags.
 */

/**
 * Enthaelt die erlaubten Statuswerte eines Auftrags.
 */
public enum Auftragsstatus {
    /** Auftrag wurde neu erstellt und noch nicht bearbeitet. */
    OFFEN,

    /** Auftrag wird aktuell bearbeitet. */
    IN_ARBEIT,

    /** Auftrag wartet auf benoetigte Teile. */
    WARTET_AUF_TEILE,

    /** Auftrag wurde fachlich abgeschlossen. */
    FERTIG,

    /** Auftrag wurde abgebrochen. */
    STORNIERT
}
