package ch.werkstattteam.werkstattpilot.persistence;

import java.util.ArrayList;
import java.util.List;

import ch.werkstattteam.werkstattpilot.business.Auftrag;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: AuftragRepositoryMock.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Mock-DB im Hauptspeicher mit einer Java Collection.
 */

/**
 * Speichert Auftrag-Objekte im Hauptspeicher.
 */
public class AuftragRepositoryMock implements AuftragRepository {

    private List<Auftrag> auftraege;

    /**
     * Erstellt eine leere Mock-DB.
     */
    public AuftragRepositoryMock() {
        auftraege = new ArrayList<Auftrag>();
    }

    public void speichern(Auftrag auftrag) {
        pruefeAuftrag(auftrag);

        int position = findePosition(auftrag.getAuftragsNummer());

        if (position >= 0) {
            throw new IllegalArgumentException("Auftragsnummer ist bereits vorhanden: " + auftrag.getAuftragsNummer());
        }

        auftraege.add(auftrag);
    }

    public Auftrag lesen(int auftragsNummer) {
        for (int i = 0; i < auftraege.size(); i++) {
            Auftrag auftrag = auftraege.get(i);

            if (auftrag.getAuftragsNummer() == auftragsNummer) {
                return auftrag;
            }
        }

        return null;
    }

    public List<Auftrag> alleLesen() {
        return new ArrayList<Auftrag>(auftraege);
    }

    public void aktualisieren(Auftrag auftrag) {
        pruefeAuftrag(auftrag);

        int position = findePosition(auftrag.getAuftragsNummer());

        if (position >= 0) {
            auftraege.set(position, auftrag);
        } else {
            throw new IllegalArgumentException("Auftrag wurde nicht gefunden: " + auftrag.getAuftragsNummer());
        }
    }

    private void pruefeAuftrag(Auftrag auftrag) {
        if (auftrag == null) {
            throw new IllegalArgumentException("Auftrag darf nicht leer sein.");
        }
    }

    private int findePosition(int auftragsNummer) {
        for (int i = 0; i < auftraege.size(); i++) {
            Auftrag auftrag = auftraege.get(i);

            if (auftrag.getAuftragsNummer() == auftragsNummer) {
                return i;
            }
        }

        return -1;
    }
}
