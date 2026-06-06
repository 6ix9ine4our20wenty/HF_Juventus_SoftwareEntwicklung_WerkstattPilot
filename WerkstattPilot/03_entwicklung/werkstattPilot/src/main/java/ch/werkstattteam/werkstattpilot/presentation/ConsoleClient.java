package ch.werkstattteam.werkstattpilot.presentation;

import java.util.List;

import ch.werkstattteam.werkstattpilot.business.Auftrag;
import ch.werkstattteam.werkstattpilot.business.AuftragService;
import ch.werkstattteam.werkstattpilot.business.AuftragServiceFactory;
import ch.werkstattteam.werkstattpilot.business.Auftragsstatus;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: ConsoleClient.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Endbenutzertest mit hart programmierten Testdaten.
 */

/**
 * Erstellt Testdaten und gibt die Aufträge auf der Konsole aus.
 */
public class ConsoleClient {

    private AuftragService auftragService;

    /**
     * Erstellt den ConsoleClient und bezieht den AuftragService über die Factory.
     */
    public ConsoleClient() {
        auftragService = AuftragServiceFactory.getInstance().createAuftragService();
    }

    /**
     * Führt den einfachen Endbenutzertest aus.
     */
    public void starten() {
        System.out.println("WerkstattPilot - Endbenutzertest Aufgabe 5");

        auftragService.auftragAnlegen(1001);
        auftragService.auftragAnlegen(1002);
        auftragService.auftragAnlegen(1003);

        auftragService.statusAendern(1002, Auftragsstatus.IN_ARBEIT);
        auftragService.statusAendern(1003, Auftragsstatus.WARTET_AUF_TEILE);

        System.out.println("Erfasste Auftraege:");
        auftraegeAusgeben(auftragService.alleAuftraegeLesen());

        System.out.println();
        System.out.println("Status von Auftrag 1001 wird auf FERTIG gesetzt.");
        auftragService.statusAendern(1001, Auftragsstatus.FERTIG);

        System.out.println();
        System.out.println("Auftraege nach Statusaenderung:");
        auftraegeAusgeben(auftragService.alleAuftraegeLesen());
    }

    private void auftraegeAusgeben(List<Auftrag> auftraege) {
        for (int i = 0; i < auftraege.size(); i++) {
            System.out.println(auftraege.get(i));
        }
    }
}
