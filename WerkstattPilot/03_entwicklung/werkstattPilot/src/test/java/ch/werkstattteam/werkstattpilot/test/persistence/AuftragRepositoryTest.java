package ch.werkstattteam.werkstattpilot.test.persistence;

import java.util.List;

import ch.werkstattteam.werkstattpilot.business.Auftrag;
import ch.werkstattteam.werkstattpilot.business.Auftragsstatus;
import ch.werkstattteam.werkstattpilot.persistence.AuftragRepository;
import ch.werkstattteam.werkstattpilot.persistence.AuftragRepositoryMock;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: AuftragRepositoryTest.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Einfache Unit-Tests fuer die Persistence-Schicht ohne externe Bibliothek.
 */

/**
 * Testet das Speichern, Lesen und Aktualisieren in der Mock-DB.
 */
public class AuftragRepositoryTest {

    /**
     * Startet die Persistence-Tests.
     *
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        speichernUndLesen();
        alleLesen();
        aktualisieren();
        doppelteAuftragsNummer();
        unbekanntenAuftragAktualisieren();

        System.out.println("Alle Persistence-Tests erfolgreich.");
    }

    private static void speichernUndLesen() {
        AuftragRepository repository = new AuftragRepositoryMock();
        Auftrag auftrag = new Auftrag(2001, Auftragsstatus.OFFEN);

        repository.speichern(auftrag);
        Auftrag gelesenerAuftrag = repository.lesen(2001);

        pruefen(gelesenerAuftrag != null, "Auftrag muss gelesen werden koennen.");
        pruefen(gelesenerAuftrag.getAuftragsNummer() == 2001, "Auftragsnummer muss 2001 sein.");
        pruefen(gelesenerAuftrag.getStatus() == Auftragsstatus.OFFEN, "Status muss OFFEN sein.");
    }

    private static void alleLesen() {
        AuftragRepository repository = new AuftragRepositoryMock();

        repository.speichern(new Auftrag(2001, Auftragsstatus.OFFEN));
        repository.speichern(new Auftrag(2002, Auftragsstatus.IN_ARBEIT));

        List<Auftrag> auftraege = repository.alleLesen();

        pruefen(auftraege.size() == 2, "Es muessen zwei Auftraege vorhanden sein.");
    }

    private static void aktualisieren() {
        AuftragRepository repository = new AuftragRepositoryMock();
        Auftrag auftrag = new Auftrag(2001, Auftragsstatus.OFFEN);

        repository.speichern(auftrag);
        auftrag.setStatus(Auftragsstatus.FERTIG);
        repository.aktualisieren(auftrag);

        Auftrag gelesenerAuftrag = repository.lesen(2001);
        pruefen(gelesenerAuftrag.getStatus() == Auftragsstatus.FERTIG, "Status muss FERTIG sein.");
    }

    private static void doppelteAuftragsNummer() {
        AuftragRepository repository = new AuftragRepositoryMock();
        boolean exceptionGeworfen = false;

        repository.speichern(new Auftrag(2001, Auftragsstatus.OFFEN));

        try {
            repository.speichern(new Auftrag(2001, Auftragsstatus.IN_ARBEIT));
        } catch (IllegalArgumentException ex) {
            exceptionGeworfen = true;
        }

        pruefen(exceptionGeworfen, "Doppelte Auftragsnummer muss eine Exception werfen.");
    }

    private static void unbekanntenAuftragAktualisieren() {
        AuftragRepository repository = new AuftragRepositoryMock();
        boolean exceptionGeworfen = false;

        try {
            repository.aktualisieren(new Auftrag(9999, Auftragsstatus.FERTIG));
        } catch (IllegalArgumentException ex) {
            exceptionGeworfen = true;
        }

        pruefen(exceptionGeworfen, "Unbekannter Auftrag darf nicht aktualisiert werden.");
    }

    private static void pruefen(boolean bedingung, String fehlertext) {
        if (!bedingung) {
            throw new RuntimeException("Test fehlgeschlagen: " + fehlertext);
        }
    }
}
