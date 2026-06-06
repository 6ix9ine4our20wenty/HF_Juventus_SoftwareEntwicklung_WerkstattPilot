package ch.werkstattteam.werkstattpilot.business;

import java.util.List;

import ch.werkstattteam.werkstattpilot.persistence.AuftragRepository;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: AuftragServiceImpl.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Einfache Umsetzung der Business-Schicht für Aufträge.
 */

/**
 * Setzt die fachlichen Operationen für Auftrag anlegen, lesen und Status ändern um.
 */
public class AuftragServiceImpl implements AuftragService {

    private AuftragRepository auftragRepository;
    private AuftragFactory auftragFactory;

    /**
     * Erstellt den Service mit einem Repository.
     *
     * @param auftragRepository Repository für Speichern und Lesen
     */
    public AuftragServiceImpl(AuftragRepository auftragRepository) {
        this.auftragRepository = auftragRepository;
        this.auftragFactory = new AuftragFactory();
    }

    public Auftrag auftragAnlegen(int auftragsNummer) {
        Auftrag auftrag = auftragFactory.erstelleAuftrag(auftragsNummer);
        auftragRepository.speichern(auftrag);
        return auftrag;
    }

    public Auftrag statusAendern(int auftragsNummer, Auftragsstatus neuerStatus) {
        Auftrag auftrag = auftragRepository.lesen(auftragsNummer);

        if (auftrag == null) {
            throw new IllegalArgumentException("Auftrag wurde nicht gefunden: " + auftragsNummer);
        }

        auftrag.setStatus(neuerStatus);
        auftragRepository.aktualisieren(auftrag);
        return auftrag;
    }

    public Auftrag auftragLesen(int auftragsNummer) {
        return auftragRepository.lesen(auftragsNummer);
    }

    public List<Auftrag> alleAuftraegeLesen() {
        return auftragRepository.alleLesen();
    }
}
