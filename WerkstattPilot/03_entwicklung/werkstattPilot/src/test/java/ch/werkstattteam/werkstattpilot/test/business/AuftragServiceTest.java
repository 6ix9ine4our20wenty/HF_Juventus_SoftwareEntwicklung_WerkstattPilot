package ch.werkstattteam.werkstattpilot.test.business;

import java.util.List;

import ch.werkstattteam.werkstattpilot.business.Auftrag;
import ch.werkstattteam.werkstattpilot.business.AuftragService;
import ch.werkstattteam.werkstattpilot.business.AuftragServiceImpl;
import ch.werkstattteam.werkstattpilot.business.Auftragsstatus;
import ch.werkstattteam.werkstattpilot.persistence.AuftragRepositoryMock;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: AuftragServiceTest.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Einfache Unit-Tests fuer die Business-Schicht ohne externe Bibliothek.
 */

/**
 * Testet die Business-Schicht fuer Auftrag anlegen, lesen und Status aendern.
 */
public class AuftragServiceTest {

    /**
     * Startet die Business-Tests.
     *
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        auftragAnlegen();
        statusAendern();
        alleAuftraegeLesen();
        unbekannteAuftragsNummer();
        ungueltigeAuftragsNummer();
        statusDarfNichtLeerSein();

        System.out.println("Alle Business-Tests erfolgreich.");
    }

    private static void auftragAnlegen() {
        AuftragService service = neuerService();

        Auftrag auftrag = service.auftragAnlegen(3001);

        pruefen(auftrag.getAuftragsNummer() == 3001, "Auftragsnummer muss 3001 sein.");
        pruefen(auftrag.getStatus() == Auftragsstatus.OFFEN, "Neuer Auftrag muss Status OFFEN haben.");
    }

    private static void statusAendern() {
        AuftragService service = neuerService();

        service.auftragAnlegen(3001);
        Auftrag auftrag = service.statusAendern(3001, Auftragsstatus.IN_ARBEIT);

        pruefen(auftrag.getStatus() == Auftragsstatus.IN_ARBEIT, "Status muss IN_ARBEIT sein.");
    }

    private static void alleAuftraegeLesen() {
        AuftragService service = neuerService();

        service.auftragAnlegen(3001);
        service.auftragAnlegen(3002);
        service.auftragAnlegen(3003);

        List<Auftrag> auftraege = service.alleAuftraegeLesen();

        pruefen(auftraege.size() == 3, "Es muessen drei Auftraege vorhanden sein.");
    }

    private static void unbekannteAuftragsNummer() {
        AuftragService service = neuerService();
        boolean exceptionGeworfen = false;

        try {
            service.statusAendern(9999, Auftragsstatus.FERTIG);
        } catch (IllegalArgumentException ex) {
            exceptionGeworfen = true;
        }

        pruefen(exceptionGeworfen, "Bei unbekannter Nummer muss eine Exception kommen.");
    }

    private static void ungueltigeAuftragsNummer() {
        AuftragService service = neuerService();
        boolean exceptionGeworfen = false;

        try {
            service.auftragAnlegen(0);
        } catch (IllegalArgumentException ex) {
            exceptionGeworfen = true;
        }

        pruefen(exceptionGeworfen, "Auftragsnummer 0 muss eine Exception werfen.");
    }

    private static void statusDarfNichtLeerSein() {
        AuftragService service = neuerService();
        boolean exceptionGeworfen = false;

        service.auftragAnlegen(3001);

        try {
            service.statusAendern(3001, null);
        } catch (IllegalArgumentException ex) {
            exceptionGeworfen = true;
        }

        pruefen(exceptionGeworfen, "Leerer Status muss eine Exception werfen.");
    }

    private static AuftragService neuerService() {
        return new AuftragServiceImpl(new AuftragRepositoryMock());
    }

    private static void pruefen(boolean bedingung, String fehlertext) {
        if (!bedingung) {
            throw new RuntimeException("Test fehlgeschlagen: " + fehlertext);
        }
    }
}
